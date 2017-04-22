package com.urishort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mike on 4/21/17.
 */
@Controller
public class ApplicationWeb {
    @Autowired
    private UriShortRepository uriShortRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String homepageView(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name",name);
        return "index";

    }

    /**
     * Request for redirect; this will redirect user to the stored long uri
     * @param uriKey
     * @return
     */
    @RequestMapping(path = "/{uriKey}",method = RequestMethod.GET)
    public String uriRedirect(@PathVariable("uriKey") String uriKey) {
        UriShort uriShort = uriShortRepository.findOne(UriKey.getUriId(uriKey));
        return "redirect:" + uriShort.getUriOriginal();

    }
}