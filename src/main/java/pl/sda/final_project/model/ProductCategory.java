package pl.sda.final_project.model;

import javax.persistence.Entity;

@Entity
public class ProductCategory extends BaseEntity {

    private String categoryTitle;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public ProductCategory() {
    }

    public ProductCategory(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
