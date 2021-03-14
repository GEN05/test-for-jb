package jb.gusarov.test.form.validator;

import jb.gusarov.test.form.UserCredentials;
import jb.gusarov.test.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCredentialsEnterValidator implements Validator {
    private final UserService userService;

    public UserCredentialsEnterValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return UserCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            UserCredentials enterForm = (UserCredentials) target;
            if (userService.findByNameAndSurnameAndPassword(enterForm.getName(), enterForm.getSurname(), enterForm.getPassword()) == null) {
                errors.rejectValue("password", "password.invalid-login-or-password", "invalid login or password");
            }
        }
    }
}
