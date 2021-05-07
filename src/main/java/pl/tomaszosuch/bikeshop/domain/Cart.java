package pl.tomaszosuch.bikeshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
    private Order order;

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> items;
}
