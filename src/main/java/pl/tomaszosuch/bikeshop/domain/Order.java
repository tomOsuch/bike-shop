package pl.tomaszosuch.bikeshop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @NonNull
    private Long id;

    @Column(name = "order_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Column(name = "comments")
    private String comments;

    @Column(name = "value")
    private BigDecimal totalValue;

    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    private Cart cart;

    public Order(@NonNull Long id, LocalDateTime orderDate, String comments, BigDecimal totalValue, boolean isCompleted) {
        this.id = id;
        this.orderDate = orderDate;
        this.comments = comments;
        this.totalValue = totalValue;
        this.isCompleted = isCompleted;
    }
}
