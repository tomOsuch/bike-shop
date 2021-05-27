package pl.tomaszosuch.bikeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomaszosuch.bikeshop.domain.Product;
import pl.tomaszosuch.bikeshop.domain.ProductGroup;
import pl.tomaszosuch.bikeshop.exception.NullArgumentException;
import pl.tomaszosuch.bikeshop.exception.ProductGroupException;
import pl.tomaszosuch.bikeshop.repository.ProductGroupRepository;
import pl.tomaszosuch.bikeshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductGroupDbServiceImpl implements ProductGroupDbService {

    @Autowired
    private ProductGroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductGroup> getGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<ProductGroup> getGroup(Long groupId) {
        return groupRepository.findById(groupId);
    }

    @Override
    public ProductGroup saveGroup(ProductGroup group) {
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long groupId) throws ProductGroupException, NullArgumentException {
        emptyGroupValidator(groupId);
        groupRepository.deleteById(groupId);
    }

    private void emptyGroupValidator(Long groupId) throws ProductGroupException, NullArgumentException {
        if (groupId == null) {
            throw new NullArgumentException(NullArgumentException.ERR_ARGUMENTS_NULL);
        }
        Optional<ProductGroup> groupDelete = groupRepository.findById(groupId);

        List<Product> products = productRepository.findAll().stream()
                .filter(product -> product.getGroup().equals(groupDelete))
                .collect(Collectors.toList());

        if (products.size() != 0) {
            throw new ProductGroupException(ProductGroupException.ERR_PRODUCTS_SIGNED_TO_GROUP);
        }
    }
}
