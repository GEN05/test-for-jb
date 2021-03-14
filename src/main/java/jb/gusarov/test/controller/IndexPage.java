package jb.gusarov.test.controller;

import jb.gusarov.test.security.Guest;
import jb.gusarov.test.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexPage extends Page {
    private final BookService bookService;

    public IndexPage(BookService bookService) {
        this.bookService = bookService;
    }

    @Guest
    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("posts", bookService.findAll());
        return "IndexPage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        unsetUser(httpSession);
        return "redirect:/";
    }
}
