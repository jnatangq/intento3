package com.proyecto.coffe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoffeController {

    @RequestMapping("/")
    public String principal() {
        return "create_product";
    }

    @RequestMapping("/products")
    public String productos() {
        return "products";
    }

    @RequestMapping("/editar")
    public String editar() {
        return "edit_product";
    }
}
