package com.ecommerce.hcd.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ecommerce.hcd.model.User;
import com.ecommerce.hcd.dto.request.UserRequest;
import com.ecommerce.hcd.dto.response.UserResponse;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);
    
    User update(Long id, User user);

    void deleteById(Long id);

    List<UserResponse> findAllDto();

    Optional<UserResponse> findByIdDto(Long id);

    UserResponse saveDto(UserRequest req);

    UserResponse updateDto(Long id, UserRequest req);

    UserResponse findByUsernameAndPassword(String username, String password);

    UserResponse findByUsername(String username);
}
