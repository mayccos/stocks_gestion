package fr.mayccos.stock.pojo;


import lombok.Data;

@Data
public class Product {
    private Long productId;
    private String productName;
    private String productDescription;
    private Float productPrice;
    private Integer productQuantity;

}
