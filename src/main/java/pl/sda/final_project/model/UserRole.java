package pl.sda.final_project.model;

import javax.persistence.Entity;

@Entity
public class UserRole extends BaseEntity {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public static UserRole apply(Roles role) {
        UserRole userRole = new UserRole();
        userRole.roleName = role.name();
        return userRole;
    }

    public enum Roles {
        ADMIN,
        USER;
    }
}
