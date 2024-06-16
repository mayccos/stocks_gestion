package fr.mayccos.stock.ws;


import fr.mayccos.stock.pojo.Product;
import fr.mayccos.stock.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductWs {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PostMapping
    public void createProduct(@Valid @RequestBody Product product) {
        this.productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        this.productService.deleteProductById(id);
    }
}
