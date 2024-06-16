package fr.mayccos.stock.pojo;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long productId;

    @Size(min=5, max=50, message="la taille doit être entre 5 et 50")
    private String productName;
    private String productDescription;
    private Float productPrice;
    private Integer productQuantity;

    public Product(String productName, String productDescription, Float productPrice, Integer productQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product() {}
}
