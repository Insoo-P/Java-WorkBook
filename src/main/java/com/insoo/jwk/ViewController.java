package com.insoo.jwk;

import org.springframework.web.bind.annotation.GetMapping;

public class ViewController {

    @GetMapping("/")
    public String indexView(){
        return "/";
    }
}
