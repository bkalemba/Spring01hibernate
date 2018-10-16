package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.beans.AuthorServiceInterface;
import pl.coderslab.beans.BookServiceInterface;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceInterface service;

    @Autowired
    AuthorServiceInterface authorServiceInterface;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        Author author = new Author();
        author.setFirstName("Benek");
        authorServiceInterface.save(author);

        book.getAuthors().add(author);
        service.save(book);
        return "Dodano książke o id: " + book.getId();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable Long id){
        return "Zmieniono książke o id: "+id;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Skasowano książke o id: "+id;
    }

    @RequestMapping("/load/{id}")
    @ResponseBody
    public String load(@PathVariable Long id){
        Book book = service.find(id);
        return book.toString();
    }

    @RequestMapping("/list")
    @ResponseBody
    public String loadAll(){
        List<Book> books = service.loadAll();
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString());
        }
        return sb.toString();
    }
}
