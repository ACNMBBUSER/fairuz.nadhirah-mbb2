package com.fairuznadhirah.productprofile.controller;

import com.fairuznadhirah.productprofile.model.ProductProfile;
import com.fairuznadhirah.productprofile.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    ProductProfile productProfile1;
    ProductProfile productProfile2;
    List<ProductProfile> productProfileList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        productProfile1 = new ProductProfile("1", "Apple", "RM7821", "fast charging");
        productProfile2 = new ProductProfile("2", "Windows", "RM4321", "fast charging with good performance");
        productProfileList.add(productProfile1);
        productProfileList.add(productProfile2);
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void getProductProfileDetails() throws Exception{
        when(productService.getProduct("1")).thenReturn(productProfile1);
        this.mockMvc.perform(get("/product" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createProductProfileDetails() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=objectWriter.writeValueAsString(productProfile1);

        when(productService.createProduct(productProfile1)).thenReturn("Success");
        this.mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

}
