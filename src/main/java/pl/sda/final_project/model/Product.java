package pl.sda.final_project.model;

import pl.sda.final_project.ProductDto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity {
    private String title;
    private String description;
    private String imageUrl;
    @ManyToOne
    private ProductCategory productCategory;
    private BigDecimal price;
    private ProductType productType;
    @Embedded
    private Author author;

    public static Product apply(ProductDto productDto) {
        Product product = new Product();
        product.title = productDto.getProductTitle();
        product.description = productDto.getDescription();
        product.imageUrl = productDto.getImageUrl();
        product.price = productDto.getPrice();
        product.productType = ProductType.valueOf(productDto.getProductType());
        product.author = Author.apply(productDto);
        return product;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
