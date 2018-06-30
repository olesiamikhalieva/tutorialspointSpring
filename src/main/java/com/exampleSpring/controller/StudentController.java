package com.exampleSpring.controller;
import com.exampleSpring.exceptions.SpringException;
import com.exampleSpring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
    }
    @RequestMapping(value = "HelloWeb/addStudent", method = RequestMethod.POST)

    public String addStudent( @ModelAttribute("HelloWeb")Student student,
                              ModelMap model) {

        if(student.getName().length() < 5 ){
            throw new SpringException("Given name is too short");
        } else {
            model.addAttribute("name", student.getName());
        }

        if( student.getAge() < 10 ){
            throw new SpringException("Given age is too low");
        } else {
            model.addAttribute("age", student.getAge());
        }
        model.addAttribute("id", student.getId());
        return "result";
    }
}
