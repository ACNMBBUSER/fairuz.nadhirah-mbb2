package com.fairuznadhirah.productprofile.service;

import com.fairuznadhirah.productprofile.model.ProductProfile;
import com.fairuznadhirah.productprofile.repository.ProductProfileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductProfileImplTest {

    @Mock
    private ProductProfileRepository productProfileRepository;
    private ProductService productService;
    ProductProfile productProfile;

    @Test
    void testCreateProductProfile(){
        mock(ProductProfile.class);
        mock(ProductProfileRepository.class);

        when(productProfileRepository.save(productProfile)).thenReturn(productProfile);
        assertThat(productService.createProduct(productProfile)).isEqualTo("Success");
    }
}
