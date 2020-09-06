package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.final_project.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByTitle(String title);
    List<Product> findAll();

}
