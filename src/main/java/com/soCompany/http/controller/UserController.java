package com.soCompany.http.controller;

import com.soCompany.dto.UserEditCreateDto;
import com.soCompany.dto.UserReadDto;
import com.soCompany.service.CompanyService;
import com.soCompany.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

@RequestMapping("/users")
@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping("/registration")
    public String registration(Model model,
                               @ModelAttribute("user") UserEditCreateDto userEditCreateDto) {
        model.addAttribute("user", userEditCreateDto);
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("role", "Junior");
        return "user/registration";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(Model model,
                           @PathVariable Integer id) {
        return userService.findById(id).map(user -> {
            model.addAttribute("user", user);
            model.addAttribute("companies", companyService.findAll());
            return "user/user";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String create(@ModelAttribute UserEditCreateDto userEditCreateDto) {
        UserReadDto userDto = userService.create(userEditCreateDto);
        return "redirect:users/" + userDto.getId();
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @ModelAttribute UserEditCreateDto userEditCreateDto) {
//        userEditCreateDto.setHireDate(new Date(2006-27-12));
        return userService.update(id, userEditCreateDto).map(user -> "redirect:/users/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        if(!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/users";
    }
}
