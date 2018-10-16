package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.beans.AuthorServiceInterface;
import pl.coderslab.model.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorServiceInterface service;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Author author = new Author();
        author.setFirstName("Thinking in Java");
        author.setLastName("Bruce Eckel");
        service.save(author);
        return "Dodano autora o id: " + author.getId();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable Long id){
        Author author = service.find(id);
        author.setFirstName("ZMIENIONO");
        service.update(author);
        return "Zmieniono autora o id: "+id;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Skasowano autora o id: "+id;
    }

    @RequestMapping("/load/{id}")
    @ResponseBody
    public String load(@PathVariable Long id){
        Author author = service.find(id);
        return author.toString();
    }
}
