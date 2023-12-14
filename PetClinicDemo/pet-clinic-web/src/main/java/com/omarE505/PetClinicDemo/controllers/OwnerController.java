package com.omarE505.PetClinicDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"","/", "/owners/index", "/owners/index.html"})
    public String listOwners(){
        return "owners/index";
    }

}
