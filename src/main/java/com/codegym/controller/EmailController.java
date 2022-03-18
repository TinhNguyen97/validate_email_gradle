//package com.codegym.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.regex.Pattern;
//
//
//
//@Controller
//public class EmailController {
//    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
//    private boolean validate(String email){
//        Pattern pattern =Pattern.compile(EMAIL_REGEX);
//        return pattern.matcher(email).matches();
//    }
//
//    @GetMapping("/")
//    public String getIndex() {
//        return "index";
//    }
//
//    @PostMapping("/validate")
//   public String validateEmail(@RequestParam("email") String email, Model model) {
//        boolean isValid = this.validate(email);
//        if (!isValid) {
//            model.addAttribute("message", "Email is invalid");
//            return "index";
//        }
//
//        model.addAttribute("email", email);
//        return "success";
//    }
//
//}



package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("/")
    ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/validate")
    ModelAndView validateEmail(@RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView("index");
        boolean isValidate = validate(email);
        if (!isValidate) {
            modelAndView.addObject("msg", "Email is invalid");
            return modelAndView;
        }
        modelAndView = new ModelAndView("success");
        modelAndView.addObject("email", email);
        return modelAndView;
    }


    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
