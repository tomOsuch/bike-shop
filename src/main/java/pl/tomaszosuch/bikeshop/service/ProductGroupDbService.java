package pl.tomaszosuch.bikeshop.service;

import pl.tomaszosuch.bikeshop.domain.ProductGroup;
import pl.tomaszosuch.bikeshop.exception.NullArgumentException;
import pl.tomaszosuch.bikeshop.exception.ProductGroupException;

import java.util.List;
import java.util.Optional;

public interface ProductGroupDbService {

    List<ProductGroup> getGroups();
    Optional<ProductGroup> getGroup(Long groupId);
    ProductGroup saveGroup(ProductGroup group);
    void deleteGroup(Long groupId) throws ProductGroupException, NullArgumentException;
}
