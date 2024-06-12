package fr.mayccos.stock.repository;

import fr.mayccos.stock.pojo.LogStock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogStockRepository extends CrudRepository<LogStock, Long>{
}
