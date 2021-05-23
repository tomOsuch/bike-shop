package pl.tomaszosuch.bikeshop.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "card_id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> items;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Order order;
}
