package com.fairuznadhirah.productprofile.service;

import com.fairuznadhirah.productprofile.model.ProductProfile;

import java.util.List;

public interface ProductService {

    public String createProduct(ProductProfile productProfile);
    public String updateProduct(ProductProfile productProfile);
    public String deleteProduct(String Id);
    public Object getProduct(String productId);
    public List<ProductProfile> getAllProduct();
    public List<ProductProfile> getByProductName(String productName);
}
