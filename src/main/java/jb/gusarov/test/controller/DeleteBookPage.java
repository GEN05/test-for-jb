package jb.gusarov.test.controller;

import jb.gusarov.test.form.UserBookForm;
import jb.gusarov.test.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class DeleteBookPage extends Page {
    private final BookService bookService;

    public DeleteBookPage(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/deleteBook")
    public String deleteBookGet(Model model) {
        model.addAttribute("deleteBook", new UserBookForm());
        return "DeleteBookPage";
    }

    @PostMapping("/deleteBook")
    public String deleteBookPost(@Valid @ModelAttribute("deleteBook") UserBookForm userBookForm,
                                 BindingResult bindingResult,
                                 HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "DeleteBookPage";
        }
        bookService.delete(userBookForm);
//        setUser(httpSession, userService.register(registerForm));
        putMessage(httpSession, "Congrats, you have been registered!");

        return "redirect:/";
    }
}
