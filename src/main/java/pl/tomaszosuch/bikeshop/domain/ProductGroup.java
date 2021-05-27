package pl.tomaszosuch.bikeshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product_group")
public class ProductGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private List<Product> products;

    public ProductGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
