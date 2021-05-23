package pl.tomaszosuch.bikeshop.service;

import pl.tomaszosuch.bikeshop.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDbService {

    List<Product> getProducts();
    Optional<Product> getProduct(Long productId);
    Product saveProduct(Product product);
    void deleteProduct(Long productId);
}
