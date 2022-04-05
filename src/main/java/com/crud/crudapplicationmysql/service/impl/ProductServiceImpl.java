package com.crud.crudapplicationmysql.service.impl;

import com.crud.crudapplicationmysql.exception.ProductNotFoundException;
import com.crud.crudapplicationmysql.model.Product;
import com.crud.crudapplicationmysql.repository.IProductRepository;
import com.crud.crudapplicationmysql.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public Integer saveProduct(Product product) {
        return repository.save(product).getPid();
    }

    @Override
    public Product FindOneProduct(Integer id) {

        /*Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException(id + "  does not exists");
        }*/
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException(" record of given id does not exists "));
    }

    @Override
    public List<Product> FindAllProduct() {
        return repository.findAll();
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.delete(FindOneProduct(id));

    }

    @Override
    public void UpdateProduct(Product product) {
        if (product.getPid() == null || !repository.existsById(product.getPid())) {
            throw new ProductNotFoundException(product.getPid() + "  not found ");
        } else
            repository.save(product);

    }
}
