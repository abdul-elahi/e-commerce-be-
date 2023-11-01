package com.ecommerce.user;

import com.ecommerce.address.Address;
import com.ecommerce.payment.PaymentInformation;
import com.ecommerce.ratingandreview.Rating;
import com.ecommerce.ratingandreview.Reviews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String firstName;
    private String lastName;
    private String password;
    private String email;
    private String role;
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address  = new ArrayList<>();
    @Embedded
    @ElementCollection
    @CollectionTable(name="paymentInfo",joinColumns = @JoinColumn(name = "user_id"))
    private  List<PaymentInformation> paymentInformation= new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reviews> reviews = new ArrayList<>();

    private LocalDateTime createdAt;
}
