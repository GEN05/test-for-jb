package jb.gusarov.test.controller;

import jb.gusarov.test.form.BookForm;
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
public class AddBookPage extends Page {
    private final BookService bookService;

    public AddBookPage(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBook")
    public String addBookGet(Model model) {
        model.addAttribute("bookForm", new BookForm());
        return "AddBookPage";
    }

    @PostMapping("/addBook")
    public String addBookPost(@Valid @ModelAttribute("bookForm") BookForm bookForm,
                              BindingResult bindingResult,
                              HttpSession httpSession) {
        if (bindingResult.hasErrors())
            return "AddBookPage";

        bookService.register(bookForm);
        putMessage(httpSession, "Congrats, book have been added!");

        return "redirect:/";
    }
}