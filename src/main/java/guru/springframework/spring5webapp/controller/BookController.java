package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.BookRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepositories bookRepositories;

    public BookController(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @RequestMapping("/book")
    public String view(Model model){
        model.addAttribute("book" ,bookRepositories.findAll());
        return "books/list";
    }
}
