package pl.sda.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.final_project.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("select case when count(ur) > 0 then true else false end from UserRole ur where lower(ur.roleName) like lower(?1)")
    boolean roleExists(String role);

    @Query("select ur from UserRole ur where lower(ur.roleName) = lower(?1)")
    UserRole findByRoleName(String name);
}
