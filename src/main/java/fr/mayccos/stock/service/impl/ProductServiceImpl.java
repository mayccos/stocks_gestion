package fr.mayccos.stock.service.impl;


import fr.mayccos.stock.pojo.Product;
import fr.mayccos.stock.repository.ProductRepository;
import fr.mayccos.stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product oldProduct = this.getProductById(id);
        if (oldProduct != null) {
           oldProduct.setProductName(product.getProductName());
           oldProduct.setProductPrice(product.getProductPrice());
           oldProduct.setProductDescription(product.getProductDescription());
           oldProduct.setProductQuantity(product.getProductQuantity());
           this.productRepository.save(oldProduct);}
    }

    @Override
    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void updateProductQuantity(Long productId, Integer quantity) {
        Product product = this.getProductById(productId);
        if (product != null){
            product.setProductQuantity(product.getProductQuantity() + quantity);
        }
    }

    @Override
    public Product getProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }


}
