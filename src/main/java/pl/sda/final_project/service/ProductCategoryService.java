package pl.sda.final_project.service;

import org.springframework.stereotype.Service;
import pl.sda.final_project.ProductCategoryDto;
import pl.sda.final_project.model.ProductCategory;
import pl.sda.final_project.repository.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategoryDto> productCategoryList() {
        return productCategoryRepository.findAll().stream()
                .map(ProductCategoryDto::apply)
                .collect(Collectors.toList());
    }

    public Optional<ProductCategory> findCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }
}
