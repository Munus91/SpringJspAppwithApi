package com.nmironov.internetshop.controller;


import com.nmironov.internetshop.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        if (logout != null) {
            model.addAttribute("msg", "you have been logged out successfully");
        }

        model.addAttribute("userForm", new User());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("userForm") @Valid final User userForm,
                            final BindingResult result) {

        if (result.hasErrors()) {

            return "login";
        }

        return "redirect:/admin/goods/";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login";

    }


}

