package com.jp.SIDEA.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jp.SIDEA.Models.Records.loginJson;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Login")
public class LoginController {


    @GetMapping
    public ModelAndView LoginView(){
        ModelAndView modelinho = new ModelAndView("login/login");
        return modelinho;
    }

    @GetMapping("/create")
    public ModelAndView createView(){
        ModelAndView modelinho = new ModelAndView("login/create");
        return modelinho;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute loginJson json, HttpServletRequest request){
        ModelAndView modelinho = new ModelAndView("login/create");
        return modelinho;
    }
}
