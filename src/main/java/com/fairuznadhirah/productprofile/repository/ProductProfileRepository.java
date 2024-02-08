package com.fairuznadhirah.productprofile.repository;

import com.fairuznadhirah.productprofile.model.ProductProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductProfileRepository extends JpaRepository<ProductProfile, String> {
    List<ProductProfile> findByName(String name);
}
