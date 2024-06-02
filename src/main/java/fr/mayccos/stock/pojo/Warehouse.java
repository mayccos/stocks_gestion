package fr.mayccos.stock.pojo;


import lombok.Data;

@Data
public class Warehouse {
    private Long warehouseId; // en base : entrepot_id
    private String warehouseName;
    private String warehouseAddress;


}
