package com.ProductMicroservice.service;

import com.ProductMicroservice.rest.CreateProductRestModel;

public interface ProductService {
    String createProduct(CreateProductRestModel productRestModel)  throws Exception;
}
