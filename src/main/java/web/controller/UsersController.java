package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UsersController {
    private UserService userService;
    @Autowired
    public UsersController (UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String showUsers (ModelMap model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "all_users";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new_user";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_user";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit_user";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_user";
        }
        userService.updateUser(user);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
