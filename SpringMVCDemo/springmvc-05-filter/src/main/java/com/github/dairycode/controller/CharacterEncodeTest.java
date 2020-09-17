package com.github.dairycode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CharacterEncodeTest {
    @PostMapping("/code")
    public String code(@RequestParam("name") String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }
}
