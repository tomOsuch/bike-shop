package pl.tomaszosuch.bikeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.tomaszosuch.bikeshop.dto.ProductDto;

import pl.tomaszosuch.bikeshop.exception.ProductNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.ProductMapper;
import pl.tomaszosuch.bikeshop.service.ProductDbServiceImpl;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductDbServiceImpl productDbService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductDbServiceImpl productDbService, ProductMapper productMapper) {
        this.productDbService = productDbService;
        this.productMapper = productMapper;
    }

    @GetMapping("/getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productDbService.getProducts());
    }

    @GetMapping("/getProduct/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return productMapper.mapToProductDto(productDbService.getProduct(productId).orElseThrow(() -> new  ProductNotFoundException("")));
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productDbService.deleteProduct(productId);
    }

    @PostMapping("/createProduct")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        productDbService.saveProduct(productMapper.mapToProduct(productDto));
        return productDto;
    }

    @PutMapping("/updateProduct/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(productDbService.saveProduct(productMapper.mapToProduct(productDto)));
    }
}
