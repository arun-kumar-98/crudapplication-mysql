package com.crud.crudapplicationmysql.service;

import com.crud.crudapplicationmysql.model.Product;

import java.util.List;

public interface IProductService {

    Integer saveProduct(Product product);

    Product FindOneProduct(Integer id);

    List<Product> FindAllProduct();

    void deleteProduct(Integer id);

    void UpdateProduct(Product product);

}
