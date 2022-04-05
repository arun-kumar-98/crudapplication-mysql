package com.crud.crudapplicationmysql.controller;

import com.crud.crudapplicationmysql.exception.ProductNotFoundException;
import com.crud.crudapplicationmysql.model.Product;
import com.crud.crudapplicationmysql.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private IProductService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveProd(@RequestBody Product product) {
        LOGGER.info("enter to perform operation");
        ResponseEntity<String> responseEntity = null;
        Integer id = service.saveProduct(product);
        LOGGER.debug("product created of {}", id);

        responseEntity = new ResponseEntity<String>("product'" + id + "'created", HttpStatus.CREATED);

        LOGGER.info("about to return response entity object");
        return responseEntity;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(service.FindAllProduct());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOneDate(@PathVariable Integer id) {
        ResponseEntity<?> productResponseEntity = null;
        LOGGER.info("enter to fetch  one record from product");
        try {
            Product product = service.FindOneProduct(id);
            LOGGER.debug("product details:{}",product);
            productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);

        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("unable to process the operation:{}",e.getMessage());
            productResponseEntity = new ResponseEntity<String>(
                    e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        LOGGER.info("about to return the response");
        return productResponseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        ResponseEntity<?> entity = null;
        try {
            service.deleteProduct(id);
            entity = new ResponseEntity<String>(id + "  deleted", HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(id + " not existed ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyproduct(@RequestBody Product product) {
        ResponseEntity<?> entity = null;
        try {
            service.UpdateProduct(product);
            entity = new ResponseEntity<String>("product updated", HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>("givern id   not existing", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return entity;
    }


}
