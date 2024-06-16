package fr.mayccos.stock.service;

import fr.mayccos.stock.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void createProduct(Product product);

    Product getProductById(Long id);

    void updateProduct(Long id, Product product);

    void deleteProductById(Long id);

    void updateProductQuantity(Long productId, Integer quantity);
}
