package fr.mayccos.stock.service.impl;


import fr.mayccos.stock.pojo.LogStock;
import fr.mayccos.stock.repository.LogStockRepository;
import fr.mayccos.stock.service.LogStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogStockServiceImpl implements LogStockService {

    @Autowired
    private LogStockRepository logStockRepository;

    @Override
    public void createLogStock(LogStock logStock) {

    }
}
