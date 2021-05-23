package pl.tomaszosuch.bikeshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszosuch.bikeshop.domain.ProductGroup;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductGroupRepository extends CrudRepository<ProductGroup, Long> {

    List<ProductGroup> findAll();
    Optional<ProductGroup> findById(Long id);
    ProductGroup save(ProductGroup group);
    void deleteById(Long id);
}
