package fr.mayccos.stock.manager;



import fr.mayccos.stock.pojo.LogStock;
import fr.mayccos.stock.service.LogStockService;
import fr.mayccos.stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogStockManager {

    @Autowired
    private ProductService productService;

    @Autowired
    private LogStockService logStockService;

    public void processLog(LogStock logStock) {

        //1. Log Integration
        this.logStockService.createLogStock(logStock);

        //2. Implementing the change
        switch (logStock.getAction()){

            case MODIFICATION ->{
                this.productService.updateProductQuantity(
                        logStock.getProduct_id(), logStock.getQuantity()
                );
                break;
            }

            case DELETION ->{
                this.productService.deleteProductById(
                        logStock.getProduct_id()
                );
                break;
            }
        }

    }
}
