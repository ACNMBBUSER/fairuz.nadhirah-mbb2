//package com.fairuznadhirah.productprofile.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "token")
//public class Token {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "token")
//    private String token;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserProfile userProfile;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public UserProfile getUserProfile() {
//        return userProfile;
//    }
//
//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }
//}
