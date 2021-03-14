package jb.gusarov.test.controller;

import jb.gusarov.test.form.ChangeCipherForm;
import jb.gusarov.test.form.UserBookForm;
import jb.gusarov.test.service.BookService;
import jb.gusarov.test.service.CommonService;
import jb.gusarov.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ChangeCipherPage extends Page {
    private final UserService userService;
    private final BookService bookService;
    private final CommonService commonService;

    public ChangeCipherPage(UserService userService, BookService bookService, CommonService commonService) {
        this.userService = userService;
        this.bookService = bookService;
        this.commonService = commonService;
    }

    @GetMapping("/changeCipher")
    public String ChangeCipherGet(Model model) {
        model.addAttribute("changeCipher", new UserBookForm());
        return "ChangeCipherPage";
    }

    @PostMapping("/changeCipher")
    public String ChangeCipherPost(@Valid @ModelAttribute("changeCipher") ChangeCipherForm changeCipherForm,
                                   BindingResult bindingResult,
                                   HttpSession httpSession) {
        if (bindingResult.hasErrors())
            return "ChangeCipherPage";
        bookService.changeCipher(changeCipherForm.getCipher(), changeCipherForm.getNewCipher());
        putMessage(httpSession, "Congrats, you successful take a book!");
        return "redirect:/books";
    }
}
