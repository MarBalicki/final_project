package pl.sda.final_project;

import pl.sda.final_project.model.ProductCategory;

public class ProductCategoryDto {

    private String categoryTitle;
    private Long productCategoryId;


    public static ProductCategoryDto apply(ProductCategory productCategory) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.categoryTitle = productCategory.getCategoryTitle();
        productCategoryDto.productCategoryId = productCategory.getId();
        return productCategoryDto;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
