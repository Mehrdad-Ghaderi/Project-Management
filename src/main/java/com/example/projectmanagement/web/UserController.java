package com.example.projectmanagement.web;

import com.example.projectmanagement.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/{userId}")
    public String displayUser(@PathVariable int userId) {
        return "<h4>User Found: " + userId + "</h4";
    }

    @RequestMapping("/{id}/invoices")
    public String displayUserInvoices(@PathVariable("id") int userId,
                                      @RequestParam(value = "date", required = false) Date dateOrNull) {
        return "<h4>Invoice Found for user: " + userId + " on the date " + dateOrNull + "</h4";
    }

    @RequestMapping("/{userID}/items")
    public List<String> displayStringJson() {
        return Arrays.asList("shoes", "laptop", "button");
    }

    @RequestMapping("/{userID}/products_as_json")
    public List<Product> displayProductsJson() {
        return Arrays.asList(new Product(1, "shoes", 42.99),
                new Product(2, "books", 12.99),
                new Product(3, "bag", 45.99));
    }
}
