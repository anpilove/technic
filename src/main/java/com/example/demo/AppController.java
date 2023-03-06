package com.example.demo;

import java.util.List;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired; // связь зависимотей
import org.springframework.data.repository.query.Param; // привязываем параметры
import org.springframework.stereotype.Controller; // класс управляющий
import org.springframework.ui.Model; // взаимодействия view controller
import org.springframework.web.bind.annotation.ModelAttribute; // связывание параметра и метода , который выводится в веб интейфейс
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; // название html страниц которые подвязываются к контролеру

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
        model.addAttribute("Technic", technic);
        return "new_technic";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTechnic(@ModelAttribute("Technic") Technic technic){
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
