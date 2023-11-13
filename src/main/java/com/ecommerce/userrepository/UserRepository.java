package com.ecommerce.userrepository;


import com.ecommerce.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}
