package com.example.cabbooking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping(method = RequestMethod.GET,path = "/helloworld")
    public String helloworld()
    {
        return "Hi Welcome";
    }
}
