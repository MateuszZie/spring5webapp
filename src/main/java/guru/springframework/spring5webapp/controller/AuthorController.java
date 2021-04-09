package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.AuthorRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepositories authorRepositories;

    public AuthorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @RequestMapping("/author")
    public String author(Model model){
        model.addAttribute("author", authorRepositories.findAll());
        return "authors/list";

    }
}