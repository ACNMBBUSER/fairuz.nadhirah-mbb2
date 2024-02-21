package com.fairuznadhirah.productprofile.controller;

import com.fairuznadhirah.productprofile.model.ProductProfile;
import com.fairuznadhirah.productprofile.response.ResponseHandler;
import com.fairuznadhirah.productprofile.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Read Specific Product details
    @GetMapping("/{productId}")
    @ApiOperation(value = "Product id", notes = "Provide product details",
                    response = ResponseEntity.class)
    public ResponseEntity<Object> getProductDetails(@PathVariable("id") String productId){
        return ResponseHandler.responseBuilder("Request product details are given here",
                HttpStatus.OK, productService.getProduct(productId));
    }

    // Read All Product details
    @GetMapping("/")
    public List<ProductProfile> getAllProductDetails()
    {
        return productService.getAllProduct();
    }

    @PostMapping("/")
    public String createProductProfileDetails(@RequestBody ProductProfile productProfile)
    {
        productService.createProduct(productProfile);
        return "Product Profile created successfully";
    }

    @PutMapping("/")
    public String updateProductProfileDetails(@RequestBody ProductProfile productProfile)
    {
        productService.updateProduct(productProfile);
        return "Product Profile updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteProductProfileDetails(@PathVariable("id") String Id)
    {
        productService.deleteProduct(Id);
        return "Product Profile deleted successfully";
    }


}
