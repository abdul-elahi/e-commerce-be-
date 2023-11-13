package com.ecommerce.service;

import com.ecommerce.exception.UserException;
import com.ecommerce.user.User;

public interface UserService {
    User findUserById(Long userId) throws UserException;

    User findUserProfileByJwt(String jwt) throws UserException;
}
