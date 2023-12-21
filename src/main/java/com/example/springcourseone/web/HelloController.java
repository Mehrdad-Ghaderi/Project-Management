package com.example.springcourseone.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting", method = RequestMethod.GET)
public class HelloController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String sayHello() {
        return "<h1>Hello</h1>";
    }

    @RequestMapping("/proper")
    //@RequestMapping(value = "/proper", method = RequestMethod.GET)   this is the default method
    public String sayProperHello() {
        return "<h1>Hello there, How are you?</h1>";
    }

    @RequestMapping("/user_entry")
    public String userForm() {
        return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +
                "  <label for=\"firstName\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"firstName\" name=\"firstName\"><br>\n" +
                "  <label for=\"lastName\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lastName\" name=\"lastName\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }

    @RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
    public String printUserGreeting(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello there, " + firstName + " " + lastName;
    }

}
