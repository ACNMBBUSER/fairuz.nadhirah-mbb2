package com.fairuznadhirah.productprofile.service.impl;

import com.fairuznadhirah.productprofile.exception.ProductProfileNotFoundException;
import com.fairuznadhirah.productprofile.model.ProductProfile;
import com.fairuznadhirah.productprofile.repository.ProductProfileRepository;
import com.fairuznadhirah.productprofile.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductProfileRepository productRepository;

    public ProductServiceImpl(ProductProfileRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String createProduct(ProductProfile productProfile) {
        productRepository.save(productProfile);
        return "Success";
    }

    @Override
    public String updateProduct(ProductProfile productProfile) {
        productRepository.save(productProfile);
        return "Success";
    }

    @Override
    public String deleteProduct(String Id) {
        productRepository.deleteById(Id);
        return "Success";
    }

    @Override
    public ProductProfile getProduct(String productId) {
        if(productRepository.findById(productId).isEmpty())
            throw new ProductProfileNotFoundException("Requested Product Profile does not exist");
        return productRepository.findById(productId).get();
    }

    @Override
    public List<ProductProfile> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductProfile> getByProductName(String productName) {
        return productRepository.findByName(productName);
    }
}
