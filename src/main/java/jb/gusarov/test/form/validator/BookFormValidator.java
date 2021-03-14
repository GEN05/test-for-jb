package jb.gusarov.test.form.validator;

import jb.gusarov.test.form.BookForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}