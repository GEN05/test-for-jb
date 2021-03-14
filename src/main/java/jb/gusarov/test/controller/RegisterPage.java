package jb.gusarov.test.controller;

import jb.gusarov.test.form.UserCredentials;
import jb.gusarov.test.form.validator.UserCredentialsRegisterValidator;
import jb.gusarov.test.security.Guest;
import jb.gusarov.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterPage extends Page {
    private final UserService userService;
    private final UserCredentialsRegisterValidator userCredentialsRegisterValidator;

    public RegisterPage(UserService userService, UserCredentialsRegisterValidator userCredentialsRegisterValidator) {
        this.userService = userService;
        this.userCredentialsRegisterValidator = userCredentialsRegisterValidator;
    }

    @InitBinder("registerForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCredentialsRegisterValidator);
    }

    @Guest
    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("registerForm", new UserCredentials());
        return "RegisterPage";
    }

    @Guest
    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("registerForm") UserCredentials registerForm,
                               BindingResult bindingResult,
                               HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "RegisterPage";
        }

        setUser(httpSession, userService.register(registerForm));
        putMessage(httpSession, "Congrats, you have been registered!");

        return "redirect:/";
    }
}