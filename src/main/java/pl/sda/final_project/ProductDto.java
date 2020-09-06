package pl.sda.final_project;

import pl.sda.final_project.model.Product;

import java.math.BigDecimal;

public class ProductDto {

    private String productTitle;
    private String description;
    private String imageUrl;
    private ProductCategoryDto productCategoryDto;
    private BigDecimal price;
    private String productType;
    private String authorFirstName;
    private String authorLastName;

    public static ProductDto apply(Product product) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setProductCategoryId(product.getProductCategory().getId());
        productCategoryDto.setCategoryTitle(product.getProductCategory().getCategoryTitle());

        ProductDto productDto = new ProductDto();
        productDto.setProductTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setProductType(product.getProductType().getPlName());
        productDto.setAuthorFirstName(product.getAuthor().getAuthorFirstName());
        productDto.setAuthorLastName(product.getAuthor().getAuthorLastName());
        productDto.setProductCategoryDto(productCategoryDto);
        return productDto;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductCategoryDto getProductCategoryDto() {
        return productCategoryDto;
    }

    public void setProductCategoryDto(ProductCategoryDto productCategoryDto) {
        this.productCategoryDto = productCategoryDto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
}
