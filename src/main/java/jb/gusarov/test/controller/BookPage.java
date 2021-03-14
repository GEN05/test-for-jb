package jb.gusarov.test.controller;

import jb.gusarov.test.domain.Book;
import jb.gusarov.test.security.Guest;
import jb.gusarov.test.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BookPage extends Page {
    private final BookService bookService;

    public BookPage(BookService bookService) {
        this.bookService = bookService;
    }

    public Long getLong(String str) {
        Long idValue = null;
        try {
            idValue = Long.parseLong(str);
        } catch (NumberFormatException e) {
            //
        }
        return idValue;
    }

    @Guest
    @GetMapping("/book/{id}")
    public String post(Model model, @PathVariable String id, HttpSession httpSession) {
        Long idValue = getLong(id);
        Book book = bookService.find(idValue);
        if (book == null) {
            putMessage(httpSession, "There is no such book");
            return "redirect:/";
        }
        model.addAttribute("book", book);
        return "BookPage";
    }

    @PostMapping("/book/{id}")
    public String post(@PathVariable String id,
                       BindingResult bindingResult,
                       HttpSession httpSession, Model model) {
        Long idValue = getLong(id);
        Book book = bookService.find(idValue);
        if (book == null) {
            putMessage(httpSession, "There is no such book");
            return "redirect:/";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", book);
            return "BookPage";
        }
        if (getUser(httpSession) == null) {
            putMessage(httpSession, "Comments available only for logged in users");
            return "redirect:/";
        }

        model.addAttribute("book", book);
        return "BookPage";
    }
}