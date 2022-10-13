package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.security.CustomUser;
import com.vietis.projectdemo_vietis.utils.WebUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model,Principal principal){
        if (principal != null) {
            CustomUser currentUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("author",currentUser);
        }
        return "login";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
