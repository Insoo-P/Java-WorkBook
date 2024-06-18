package com.insoo.jwk.link;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/link/view")
public class LinkViewController {

    @GetMapping("apiExample")
    public String viewApiExample(){
        return "apiExample";
    }
}
