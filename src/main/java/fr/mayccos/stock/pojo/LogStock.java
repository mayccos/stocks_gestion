package fr.mayccos.stock.pojo;


import fr.mayccos.stock.pojo.state.Action;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="log")
public class LogStock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Action action;
    private Long product_id;
    private Integer quantity;


}
