package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.beans.BookDao;
import pl.coderslab.beans.PublisherServiceInterface;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherServiceInterface service;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Publisher publisher = new Publisher();
        publisher.setName("Thinking in Java");
        service.save(publisher);
        return "Dodano autora o id: " + publisher.getId();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable Long id){
        Publisher publisher = service.find(id);
        service.update(publisher);
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
        Publisher publisher = service.find(id);
        return publisher.toString();
    }
}
