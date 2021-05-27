package pl.tomaszosuch.bikeshop.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.bikeshop.domain.ProductGroup;
import pl.tomaszosuch.bikeshop.dto.ProductGroupDto;
import pl.tomaszosuch.bikeshop.exception.NullArgumentException;
import pl.tomaszosuch.bikeshop.exception.ProductGroupException;
import pl.tomaszosuch.bikeshop.exception.ProductNotFoundException;
import pl.tomaszosuch.bikeshop.mapper.ProductGroupMapper;
import pl.tomaszosuch.bikeshop.service.ProductGroupDbServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class ProductGroupController {

    @Autowired
    private ProductGroupDbServiceImpl groupDbService;

    @Autowired
    private ProductGroupMapper groupMapper;

    @GetMapping("/getGroups")
    public List<ProductGroupDto> getGroups() {
        return groupMapper.mapToProductGroupDtoList(groupDbService.getGroups());
    }

    @GetMapping("/getGroup/{groupId}")
    public ProductGroupDto getGroup(@PathVariable Long groupId) throws NotFoundException {
        return groupMapper.mapToProductGroupDto(groupDbService.getGroup(groupId).orElseThrow(() -> new NotFoundException("")));
    }

    @PostMapping("/createGroup")
    public ProductGroupDto createGroup(ProductGroupDto productGroupDto) {
        groupDbService.saveGroup(groupMapper.mapToProductGroup(productGroupDto));
        return productGroupDto;
    }

    @PutMapping("/updateGroup/{groupId}")
    public ProductGroupDto updateGroup(@PathVariable Long groupId, @RequestBody ProductGroupDto productGroupDto) {
        return groupMapper.mapToProductGroupDto(groupDbService.saveGroup(groupMapper.mapToProductGroup(productGroupDto)));
    }

    @DeleteMapping("/deleteGroup/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) throws NullArgumentException, ProductGroupException {
        groupDbService.deleteGroup(groupId);
    }
}
