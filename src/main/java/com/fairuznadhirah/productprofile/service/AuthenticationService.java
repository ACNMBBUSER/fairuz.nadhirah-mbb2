package com.fairuznadhirah.productprofile.service;

import com.fairuznadhirah.productprofile.model.AuthenticationResponse;
import com.fairuznadhirah.productprofile.model.UserProfile;
import com.fairuznadhirah.productprofile.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;


    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserProfile request){

        //to check if user already exist
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return new AuthenticationResponse(null, "User already exist");
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setName(request.getName());
        userProfile.setUsername(request.getUsername());
        userProfile.setPassword(passwordEncoder.encode(request.getPassword()));

        userProfile.setRole(request.getRole());

        userProfile = userRepository.save(userProfile);

        String jwt = jwtService.generateToken(userProfile);


        return new AuthenticationResponse(jwt,"User registration was successful");
    }

    public AuthenticationResponse response(UserProfile request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserProfile userProfile = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(userProfile);

        return new AuthenticationResponse(jwt, "User login was successful");
    }


}
