package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping(value = "/")
    public String printCars(ModelMap model) {
        model.addAttribute("users", userServiceImpl.listUsers());
        return "admin/admin";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(ModelMap model, @PathVariable long id) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "admin/edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user, ModelMap model) {
        userServiceImpl.setRole(user,user.getRoles().stream().findAny().get());
        userServiceImpl.updateUser(user);
        model.addAttribute("users", userServiceImpl.listUsers());
        return "redirect:/admin/";
    }

    @PostMapping(value = "/add")
    public String createUser(@ModelAttribute("user") User user, ModelMap model) {
        userServiceImpl.setRole(user,user.getRoles().stream().findAny().get());
        userServiceImpl.add(user);
        model.addAttribute("users", userServiceImpl.listUsers());
        return "redirect:/admin/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, ModelMap model) {
        userServiceImpl.deleteUser(id);
        model.addAttribute("users", userServiceImpl.listUsers());
        return "redirect:/admin/";
    }


    @GetMapping("/error")
    public String errorUser(ModelMap model) {
        return "error";
    }
}
