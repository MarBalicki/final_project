package pl.sda.final_project.model;

import pl.sda.final_project.RegistrationDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
    private LocalDate date;
    private String pesel;
    private String login;
    private String password;
    private String phoneNumber;
    private boolean preferEmail;
    @ManyToMany
    private List<UserRole> roles;

    public static User apply(RegistrationDto registrationDto, String password) {
        User user = new User();
        user.firstName = registrationDto.getFirstName();
        user.lastName = registrationDto.getLastName();
        user.address = Address.apply(registrationDto);
        user.date = LocalDate.parse(registrationDto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        user.pesel = registrationDto.getPesel();
        user.login = registrationDto.getLogin();
        user.password = password;
        user.phoneNumber = registrationDto.getPhoneNumber();
        user.preferEmail = registrationDto.isPreferEmail();
        return user;
    }

    public void addRole(UserRole userRole) {
        if (roles != null && roleExist(userRole)) {
            return;
        }
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(userRole);
    }

    private boolean roleExist(UserRole userRole) {
        return roles.stream()
                .anyMatch(r -> userRole.getRoleName().equals(r.getRoleName()));
    }


}
