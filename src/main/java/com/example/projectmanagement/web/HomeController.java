package com.example.projectmanagement.web;

import com.example.projectmanagement.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("formData", new User());
        return "new-project";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String ProcessFormData(User user, RedirectAttributes attr) {
        attr.addFlashAttribute("user", user);
        return "redirect:/display"; // calls the next method, two method is actually called
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String displayFormData(User user) {
        return "result";
    }
}
