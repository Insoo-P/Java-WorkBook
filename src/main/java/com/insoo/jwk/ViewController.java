package com.insoo.jwk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String indexView(){
        System.out.println("test");
        return "index.html";
    }
}
