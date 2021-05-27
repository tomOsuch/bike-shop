package pl.tomaszosuch.bikeshop.mapper;

import org.springframework.stereotype.Component;
import pl.tomaszosuch.bikeshop.domain.ProductGroup;
import pl.tomaszosuch.bikeshop.dto.ProductGroupDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductGroupMapper {

    public ProductGroup mapToProductGroup(final ProductGroupDto groupDto) {
        return new ProductGroup(
                groupDto.getId(),
                groupDto.getName()
        );
    }

    public ProductGroupDto mapToProductGroupDto(final ProductGroup group) {
        return new ProductGroupDto(
                group.getId(),
                group.getName()
        );
    }

    public List<ProductGroup> mapToProductList(final List<ProductGroupDto> groupDtoList) {
        return groupDtoList.stream()
                .map(this::mapToProductGroup)
                .collect(Collectors.toList());
    }

    public List<ProductGroupDto> mapToProductGroupDtoList(final List<ProductGroup> groupList) {
        return groupList.stream()
                .map(this::mapToProductGroupDto)
                .collect(Collectors.toList());
    }
}
