package pl.tomaszosuch.bikeshop.controller;

import org.springframework.web.bind.annotation.*;

import pl.tomaszosuch.bikeshop.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping("/getProducts")
    public List<ProductDto> getProducts() {
        return List.of(
            new ProductDto(1L, "Rower", " Rower szosowy", new BigDecimal(40000), true)
        );
    }

    @GetMapping("/getProduct/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1L, "Rower", " Rower szosowy", new BigDecimal(40000), true);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Long productId) {

    }

    @PostMapping("/createProduct")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "Rower", " Rower szosowy", new BigDecimal(40000), true);
    }

    @PutMapping("/updateProduct/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
        return new ProductDto(1L, "Rower", " Rower szosowy", new BigDecimal(40000), true);
    }
}
