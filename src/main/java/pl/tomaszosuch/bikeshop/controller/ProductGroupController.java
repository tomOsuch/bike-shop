package pl.tomaszosuch.bikeshop.controller;

import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.ProductGroup;
import pl.tomaszosuch.bikeshop.dto.ProductGroupDto;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class ProductGroupController {

    @GetMapping("/getGroups")
    public List<ProductGroupDto> getGroups() {
        return List.of(
                new ProductGroupDto(1L, "Szosowe"),
                new ProductGroupDto(2L, "Grawel")
        );
    }

    @GetMapping("/getGroup/{groupId}")
    public ProductGroupDto getGroup(@PathVariable Long groupId) {
        return new ProductGroupDto(1L, "Szosowe");
    }

    @PostMapping("/createGroup")
    public void createGroup(ProductGroup productGroup) {

    }

    @PutMapping("/updateGroup/{groupId}")
    public ProductGroupDto updateGroup(@PathVariable Long groupId, @RequestBody ProductGroupDto productGroupDto) {
        return new ProductGroupDto(2L, "Grawel");
    }
}
