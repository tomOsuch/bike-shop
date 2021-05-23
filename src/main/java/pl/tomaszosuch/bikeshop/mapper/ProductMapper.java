package pl.tomaszosuch.bikeshop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.tomaszosuch.bikeshop.domain.Product;
import pl.tomaszosuch.bikeshop.dto.ProductDto;
import pl.tomaszosuch.bikeshop.repository.ProductGroupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private ProductGroupRepository groupRepository;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.isAvailable(),
                groupRepository.findById(productDto.getProductGroup().getId()).orElse(null)
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.isAvailable(),
                groupRepository.findById(product.getGroup().getId()).orElse(null)
        );
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> products) {
        return products.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
