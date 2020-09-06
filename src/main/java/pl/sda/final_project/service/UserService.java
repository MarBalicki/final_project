package pl.sda.final_project.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.final_project.RegistrationDto;
import pl.sda.final_project.model.User;
import pl.sda.final_project.model.UserRole;
import pl.sda.final_project.repository.UserRepository;
import pl.sda.final_project.repository.UserRoleRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationDto registrationDto) {
        String password = passwordEncoder.encode(registrationDto.getPassword());
        if (userWithEmailExists(registrationDto.getLogin())) {
            throw new RuntimeException("Użytkownik o takim emailu " + registrationDto.getLogin() + " istnieje!");
        }
        User userToSave = User.apply(registrationDto, password);
        userToSave.addRole(userRoleRepository.findByRoleName(UserRole.Roles.USER.name()));
        userRepository.save(userToSave);
    }

    private boolean userWithEmailExists(String login) {
        return userRepository.existsByLogin(login);
    }
}
