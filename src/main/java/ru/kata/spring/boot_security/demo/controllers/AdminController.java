package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value ="")
    public String adminPanel(Model model, Principal principal) {
        model.addAttribute("user", userService.findByEmail(principal.getName()));
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("roleList", roleService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user, @RequestParam("roles") Long[] rolesId) {
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

}