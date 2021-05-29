package com.danilo.social.networking.hunter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    @GetMapping (path = "/hello")
    public ResponseEntity<String> hi()
    {
        return ResponseEntity.ok().body("hi");
    }

}
