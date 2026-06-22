package quyha.ut.edu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import quyha.ut.edu.pojo.Student;
import quyha.ut.edu.service.IStudentService;
import quyha.ut.edu.service.StudentService;

@Controller
public class HomeController {

    private IStudentService studentService = new StudentService("JPAs");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("student", new Student());

        List<Student> studentList = studentService.findAll();
        mav.addObject("studentList", studentList);

        return mav;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("student") Student student,
                           @RequestParam("action") String action) {
        if ("add".equals(action)) {
            studentService.save(student);
        } else if ("update".equals(action)) {
            studentService.update(student);
        } else if ("delete".equals(action)) {
            studentService.delete(student.getId());
        }

        return "redirect:/";
    }
}

