package org.toleyko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.toleyko.entities.Programmers;
import org.toleyko.services.ProgrammersService;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ProgrammersService programmersServiceImpl;

    @RequestMapping("/")
    public String showIndex() {
        return "redirect:/showAllUsers";
    }

    @RequestMapping("/showAllUsers")
    public String showAllUSers(Model model) {
        List<Programmers> allProgrammers = programmersServiceImpl.getAllProgrammers();
        model.addAttribute("allProg", allProgrammers);
        return "showAllUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("newProgrammer", new Programmers());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String showAddedUser(@ModelAttribute("newProgrammer") Programmers programmer, BindingResult bindingResult) {
        programmersServiceImpl.saveProgrammer(programmer);
        return "redirect:/showAllUsers";
    }

    @RequestMapping("/deleteProgrammer")
    public String deleteUser(@RequestParam("personId") Integer id) {
        programmersServiceImpl.deleteProgrammer(id);
        return "redirect:/showAllUsers";
    }

}
