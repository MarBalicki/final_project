package pl.sda.final_project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sda.final_project.ProductDto;
import pl.sda.final_project.model.Product;
import pl.sda.final_project.model.ProductCategory;
import pl.sda.final_project.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryService productCategoryService;

    public ProductService(ProductRepository productRepository, ProductCategoryService productCategoryService) {
        this.productRepository = productRepository;
        this.productCategoryService = productCategoryService;
    }

    public void saveProduct(ProductDto productDto) {
        Product product = Product.apply(productDto);
        Long productCategoryId = productDto.getProductCategoryDto().getProductCategoryId();
        ProductCategory productCategory = productCategoryService
                .findCategoryById(productCategoryId)
                .orElseThrow(() -> new RuntimeException("Can't find category!"));
        product.setProductCategory(productCategory);
        productRepository.save(product);
    }

    public Page<ProductDto> getAllProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        List<ProductDto> collect = page.stream()
                .map(ProductDto::apply)
                .collect(Collectors.toList());
        return new PageImpl<>(collect, pageable, page.getTotalElements());
    }
}
