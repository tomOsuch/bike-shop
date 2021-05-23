package pl.tomaszosuch.bikeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.bikeshop.domain.Product;
import pl.tomaszosuch.bikeshop.exception.ProductNotFoundException;
import pl.tomaszosuch.bikeshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductDbServiceImpl implements ProductDbService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
        } catch (ProductNotFoundException e) {
            throw new ProductNotFoundException("");
        }
    }
}
