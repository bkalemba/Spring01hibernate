package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.beans.PersonServiceInterface;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServiceInterface service;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Person person = new Person();
        person.setLogin("Thinking in Java");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Jan");
        person.setPersonDetails(personDetails);
        service.save(person);
        return "Dodano autora o id: " + person.getId();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable Long id){
        Person person = service.find(id);
        service.update(person);
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
        Person person = service.find(id);
        return person.toString();
    }
}
