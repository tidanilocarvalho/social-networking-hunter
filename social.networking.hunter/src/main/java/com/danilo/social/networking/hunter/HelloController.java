package com.danilo.social.networking.hunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Autowired 
    private ApplicationAvailability applicationAvailability;

    @GetMapping (path = "/hello")
    public ResponseEntity<String> sayHi()
    {
        return ResponseEntity.ok().body("hi");
    }

    @GetMapping (path = "/error")
    public ResponseEntity<String> throwError()
    {
        throw new RuntimeException("Unknow Error");
    }
    
    @GetMapping (path = "/availability")
    public ResponseEntity<ApplicationAvailability> getApplicationAvailability()
    {
        return ResponseEntity.ok().body(applicationAvailability);
    }
}
