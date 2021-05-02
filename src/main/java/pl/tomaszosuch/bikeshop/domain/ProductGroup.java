package pl.tomaszosuch.bikeshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_GROUP")
public class ProductGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
