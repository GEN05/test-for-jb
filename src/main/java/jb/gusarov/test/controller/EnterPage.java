package jb.gusarov.test.controller;

import jb.gusarov.test.form.UserCredentials;
import jb.gusarov.test.form.validator.UserCredentialsEnterValidator;
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
public class EnterPage extends Page {
    private final UserService userService;
    private final UserCredentialsEnterValidator userCredentialsEnterValidator;

    public EnterPage(UserService userService, UserCredentialsEnterValidator userCredentialsEnterValidator) {
        this.userService = userService;
        this.userCredentialsEnterValidator = userCredentialsEnterValidator;
    }

    @InitBinder("enterForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCredentialsEnterValidator);
    }

    @Guest
    @GetMapping("/enter")
    public String enter(Model model) {
        model.addAttribute("enterForm", new UserCredentials());
        return "EnterPage";
    }

    @Guest
    @PostMapping("/enter")
    public String enter(@Valid @ModelAttribute("enterForm") UserCredentials enterForm,
                        BindingResult bindingResult,
                        HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "EnterPage";
        }

        setUser(httpSession, userService.findByNameAndSurnameAndPassword(enterForm.getName(), enterForm.getSurname(), enterForm.getPassword()));
        putMessage(httpSession, "Hello, " + getUser(httpSession).getName());

        return "redirect:/";
    }
}
