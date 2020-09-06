package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.final_project.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    @Query("select case when count(pc) > 0 then true else false end from ProductCategory pc where lower(pc.categoryTitle) like lower(?1) ")
    boolean existsByCategoryTitle(String title);
}
