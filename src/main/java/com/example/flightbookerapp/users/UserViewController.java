package com.example.flightbookerapp.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
@Slf4j
public class UserViewController {
    private boolean validEmail = true;
    private boolean validPassword = true;

    private User user2;
    private final UserService userService;
    private final IUserRepository iUserRepository;

    @GetMapping("/login")
    public String logIn(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("validEmail",validEmail);
        model.addAttribute("validPassword",validPassword);

        return "login";
    }

    @PostMapping("/log")
    public String getUser(@ModelAttribute User input) {

        user2 = userService.findByEmail(input.email);
        if (user2 == null){
            validEmail = false;
            log.info("User does not exists!");
            return "redirect:/login";
        }
        validPassword = true;
        validEmail = true;
        if (!user2.getPassword().equals(input.password)) {
            validPassword = false;
            log.info("Your password is incorrect ! ");
            return "redirect:/login";
        }
        log.info("success!");
            return "redirect:/user";
            //todo
        // one boolean must be modified

    }
    @GetMapping("/user")
    public String userInterface(Model model){
        log.info(user2.toString());
        model.addAttribute("user", user2);
        return "home";
    }

}
