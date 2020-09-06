package pl.sda.final_project;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.sda.final_project.model.ProductCategory;
import pl.sda.final_project.model.UserRole;
import pl.sda.final_project.repository.ProductCategoryRepository;
import pl.sda.final_project.repository.UserRoleRepository;

@Component
public class DataSeed implements InitializingBean {
    //afterPropertiesSet() runs after SPRING context init

    private final UserRoleRepository userRoleRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public DataSeed(UserRoleRepository userRoleRepository, ProductCategoryRepository productCategoryRepository) {
        this.userRoleRepository = userRoleRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public void afterPropertiesSet() {
        createRole(UserRole.Roles.USER);
        createRole(UserRole.Roles.ADMIN);
        addCategory(new ProductCategory("Elektronika"));
        addCategory(new ProductCategory("Książki"));

    }

    private void createRole(UserRole.Roles role) {
        if (!userRoleRepository.roleExists(role.name())) {
            userRoleRepository.save(UserRole.apply(role));
        }
    }

    private void addCategory(ProductCategory productCategory) {
        if (!productCategoryRepository.existsByCategoryTitle(productCategory.getCategoryTitle())) {
            productCategoryRepository.save(productCategory);
        }
    }
}
