package pl.sda.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.final_project.RegistrationDto;
import pl.sda.final_project.service.UserService;
import pl.sda.final_project.model.Country;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("registrationObject", registrationDto);
        model.addAttribute("countries", Country.values());
        return "registrationPage";
    }

    @PostMapping("/register")
    public String registrationEffect(RegistrationDto registrationDto) {
        userService.registerUser(registrationDto);
        return "redirect:/login";

    }

}
