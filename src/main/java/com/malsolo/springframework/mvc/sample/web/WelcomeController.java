package com.malsolo.springframework.mvc.sample.web;


import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author jbeneito
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/welcome", method = GET)
    public String welcome(Model model) {
        Date today = new Date();
        model.addAttribute("today", today);
        return "welcome";
    }
}
