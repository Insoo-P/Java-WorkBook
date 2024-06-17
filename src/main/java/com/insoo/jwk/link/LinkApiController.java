package com.insoo.jwk.link;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/link/api")
public class LinkApiController {

    @GetMapping("/test")
    public Map<String, Object> test(){
        System.out.println("TEST");
        Map<String, Object> map = new HashMap<>();
        map.put("test1","value1");
        map.put("test2","value2");

        return map;
    }
}
