package com.fairuznadhirah.productprofile.repository;

import com.fairuznadhirah.productprofile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserProfile, Integer> {

    Optional<UserProfile> findByUsername(String username);
}
