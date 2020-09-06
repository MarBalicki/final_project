package pl.sda.final_project.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.final_project.ProductDto;
import pl.sda.final_project.model.ProductType;
import pl.sda.final_project.service.ProductCategoryService;
import pl.sda.final_project.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    public ProductController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }

    public List<ProductDto> getProductList() {
        ProductDto productDto = new ProductDto();
        productDto.setAuthorFirstName("kos");
        productDto.setAuthorLastName("kos2");
        productDto.setProductTitle("Ziemniak");
        productDto.setPrice(BigDecimal.valueOf(5000000000L));
        ProductDto productDto2 = new ProductDto();
        productDto2.setAuthorFirstName("kosiasty");
        productDto2.setAuthorLastName("kosiasty2");
        productDto2.setProductTitle("Pyra");
        productDto2.setPrice(BigDecimal.valueOf(2));
        return List.of(productDto,productDto2);
    }

    @GetMapping("/all")
    public ModelAndView getProducts(Pageable pageable) {
        ModelAndView mav = new ModelAndView("productList");
        Page<ProductDto> allProducts = productService.getAllProducts(pageable);
        mav.addObject("allProducts", allProducts);
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView saveProductForm() {
        ModelAndView mav = new ModelAndView("addProduct");
        ProductDto productDto = new ProductDto();
        mav.addObject("productToSave", productDto);
        mav.addObject("productCategories", productCategoryService.productCategoryList());
        mav.addObject("productTypes", ProductType.values());
        return mav;
    }

    @PostMapping("/add")
    public String saveProductForm(@ModelAttribute ProductDto productDto) {
        productService.saveProduct(productDto);
        return "redirect:/product/all";
    }
}
