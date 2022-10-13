package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.security.CustomUser;
import com.vietis.projectdemo_vietis.utils.WebUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/403")
    public String accessDenied(Principal principal) {
        if (principal != null) {
            CustomUser currentUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String userInfo = WebUtils.toString(currentUser);
            String message = "Hi " + principal.getName() + "<br> You do not have permission to access this page!";
            System.err.println(userInfo);
            System.err.println(message);
        }
        return "403";
    }
}
