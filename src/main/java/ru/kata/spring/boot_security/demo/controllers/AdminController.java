package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String userList(Model model) { //все+
        model.addAttribute("usersList", userService.allUsers());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", roleService.getAllRole());
        return "create";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.addUser(user);

        return "redirect:/admin";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("role", roleService.getAllRole());
        return "edit";
    }

    @PutMapping("/edit")
    public String update(@ModelAttribute(value = "user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping ("users") //удаление+
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}