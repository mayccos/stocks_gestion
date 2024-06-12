package fr.mayccos.stock.pojo;


import fr.mayccos.stock.pojo.state.Action;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="log")
public class LogStock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private Action action;
    private Long product_id;
    private Long quantity;


}
