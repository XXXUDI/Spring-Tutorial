package com.soCompany.http.controller;

import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
        return null;
    }

    @GetMapping("/{id}")
    public String findById(Model model,
                           @PathVariable Integer id) {
        return null;
    }

    @PostMapping
    public String create(Model model,
                         @ModelAttribute UserEditCreateDto userEditCreateDto) {
        return null;
    }

    @PostMapping("/{id}/update")
    public String update(Model model,
                         @PathVariable Long id,
                         @ModelAttribute UserEditCreateDto userEditCreateDto) {
        return null;
    }

    @PostMapping("/{id}/delete")
    public String delete(Model model,
                         @PathVariable Long id){
        return null;
    }
}
