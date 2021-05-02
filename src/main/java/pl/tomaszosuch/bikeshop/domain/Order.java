package pl.tomaszosuch.bikeshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "comments")
    private String comments;

    @Column(name = "value")
    private BigDecimal totalValue;

    private boolean isCompleted;
}
