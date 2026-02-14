package com.ecommerce.hcd.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.hcd.model.User;
import com.ecommerce.hcd.repository.UserRepository;
import com.ecommerce.hcd.service.interfaces.UserService;
import com.ecommerce.hcd.dto.request.UserRequest;
import com.ecommerce.hcd.dto.response.UserResponse;
import com.ecommerce.hcd.mapper.UserMapper;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> findAllDto() {
        List<User> users = userRepository.findAll();
        List<UserResponse> out = new ArrayList<>();
        for (User u : users) out.add(UserMapper.toResponse(u));
        return out;
    }

    @Override
    public java.util.Optional<UserResponse> findByIdDto(Long id) {
        return userRepository.findById(id).map(UserMapper::toResponse);
    }

    @Override
    public UserResponse saveDto(UserRequest req) {
        User u = UserMapper.toEntity(req);
        User saved = userRepository.save(u);
        return UserMapper.toResponse(saved);
    }

    @Override
    public UserResponse updateDto(Long id, UserRequest req) {
        User u = UserMapper.toEntity(req);
        u.setId(id);
        User saved = userRepository.save(u);
        return UserMapper.toResponse(saved);
    }

    @Override
    public UserResponse findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(UserMapper::toResponse)
                .orElse(null);
    }

    @Override
    public UserResponse findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserMapper::toResponse)
                .orElse(null);
    }

}
