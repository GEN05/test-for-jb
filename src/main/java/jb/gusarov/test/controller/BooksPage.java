package jb.gusarov.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksPage extends Page {
    @GetMapping("/books")
    public String posts() {
        return "BooksPage";
    }
}