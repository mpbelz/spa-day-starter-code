package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller

@RequestMapping("user")

public class UserController {
    @GetMapping

    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
//        System.out.println(user.getPassword());
//        System.out.println(verify);
//        System.out.println((user.getPassword().equals(verify)));
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        if (user.getPassword().equals(verify)) {
//            System.out.println("hello");
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords do not match!");
            return "user/add";
        }
    }
}
