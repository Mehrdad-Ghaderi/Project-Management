package com.example.springcourseone.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/{userId}")
    public String displayUser(@PathVariable int userId) {
        return "<h4>User Found: " + userId + "</h4";
    }

    @RequestMapping("/{userId}/invoices")
    public String displayUserInvoices(@PathVariable int userId,
                                      @RequestParam(value= "date", required = false) Date dateOrNull) {
        return "<h4>Invoice Found for user: " + userId + " on the date " + dateOrNull +"</h4";
    }
}
