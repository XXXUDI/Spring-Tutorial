package com.soCompany.http.controller;

import com.soCompany.database.CompanyRepository;
import com.soCompany.dto.unusable.ClientReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @ModelAttribute("ClientDto")
    public ClientReadDto clientReadDto() {
        return new ClientReadDto("Kasha", 3);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView mv, CompanyRepository repository) {
        mv.setViewName("greeting/hello");
        return mv;
    }

    @GetMapping("/bye/{name}")
    public String bye(@PathVariable("name") String name,
                      Model model,
                      ClientReadDto readDto) {
        model.addAttribute("name", name);
        model.addAttribute("dto", readDto);
        return "greeting/bye";
    }
}
