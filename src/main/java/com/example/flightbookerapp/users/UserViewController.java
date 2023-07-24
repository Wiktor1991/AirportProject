package com.example.flightbookerapp.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
@Slf4j
public class UserViewController {
    private boolean validEmail = true;
    private boolean validPassword = true;
    private  boolean isSaved;

    private User user2;
    private final UserService userService;

    @GetMapping("/login")
    public String logIn(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("validEmail",validEmail);
        model.addAttribute("validPassword",validPassword);

        return "login";
    }

    @PostMapping("/log")
    public String getUser(@ModelAttribute User input) {
        validPassword = true;
        validEmail = true;
        user2 = userService.findByEmail(input.email);
        if (user2 == null){
            validEmail = false;
            log.info("User does not exists!");
            return "redirect:/login";
        }
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
        model.addAttribute("user", user2);
        boolean isUser = user2.type.equals("user");
        model.addAttribute("isUser",isUser);
        return "home";
    }
    @GetMapping("registry")
    public String registry(Model model, String password){
        model.addAttribute("newUser", new User());
        model.addAttribute("pass", password);
        model.addAttribute("valid",validPassword);
        model.addAttribute("saved", isSaved);
        return "registry";
    }

    @PostMapping("/createAccount")
    public String newUser(@ModelAttribute("newUser") User user,
                          @ModelAttribute("pass") String password){
        validPassword = true;
        isSaved = false;

        if (user.password.equals(password)){
            userService.addNew(new User(user.email,user.password,"user"));
            isSaved = true;
        }else{
            validPassword = false;
        }
        return "redirect:/registry";
    }
}
