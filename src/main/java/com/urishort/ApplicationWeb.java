package com.urishort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mike on 4/21/17.
 */
@Controller
public class ApplicationWeb {
    /*
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String homepageMe() {
        return "index";

    }
    */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homepageView(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name",name);
        return "index";

    }
}