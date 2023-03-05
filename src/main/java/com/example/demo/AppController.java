package com.example.demo;

import java.util.List;

import jakarta.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private TechnicService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Technic> listTechnic = service.listAll(keyword);
        model.addAttribute("listTechnic", listTechnic);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewTechnicForm(Model model){
        Technic technic = new Technic();
        model.addAttribute("technic", technic);
        return "new_technic";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTechnic(@ModelAttribute("technic") Technic technic){
        service.save(technic);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTechnicFrom(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_technic");
        Technic technic = service.get(id);
        mav.addObject("Technic", technic);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteTechnic(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";

    }


}
