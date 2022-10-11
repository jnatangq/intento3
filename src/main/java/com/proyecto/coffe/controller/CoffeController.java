package com.proyecto.coffe.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.coffe.Entity.Tipo;
import com.proyecto.coffe.Entity.Product;
import com.proyecto.coffe.Repository.ITipoRepository;
import com.proyecto.coffe.service.ProductService;

@Controller
public class CoffeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ITipoRepository tipoRepository;

    private List<Tipo> tiposList = new ArrayList<>();

    public CoffeController(ProductService productService, ITipoRepository tipoRepository) {
        this.productService = productService;
        this.tipoRepository = tipoRepository;

        this.tiposList = this.tipoRepository.findAllSortByTipo();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/products/new")
    public String createStudentForm(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);
        model.addAttribute("tiposList", tiposList);

        return "create_product";
    }

    
    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/students";
    }


    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product pt = productService.getProductById(id);

        model.addAttribute("product", pt);
        model.addAttribute("tiposList", tiposList);

        return "edit_product";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,
            @ModelAttribute("product") Product product,
            Model model) {
        // sacar el estudiante de la b.d. por el id
        Product existentProduct = productService.getProductById(id);
        // cargarlo
        existentProduct.setId(id);
        existentProduct.setProductName(product.getProductName());
        existentProduct.setProductPrice(product.getProductPrice());
        existentProduct.setProductType(product.getProductType());
        existentProduct.setTipos(product.getTipos());

        // guardar el estudiante actualizado
        productService.updateProduct(existentProduct);

        return "redirect:/products";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/students";
    }

}

      