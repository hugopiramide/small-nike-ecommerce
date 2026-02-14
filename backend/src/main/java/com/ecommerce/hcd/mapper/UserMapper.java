package com.ecommerce.hcd.mapper;

import com.ecommerce.hcd.dto.request.UserRequest;
import com.ecommerce.hcd.dto.response.UserResponse;
import com.ecommerce.hcd.model.User;

public class UserMapper {

    public static User toEntity(UserRequest req) {
        if (req == null) return null;
        User u = new User();
        u.setUsername(req.getUsername());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setProfileImgUrl(req.getProfileImgUrl());
        u.setName(req.getName());
        u.setSurnames(req.getSurnames());
        u.setBirthday(req.getBirthday());
        return u;
    }

    public static UserResponse toResponse(User u) {
        if (u == null) return null;
        UserResponse r = new UserResponse();
        r.setId(u.getId());
        r.setUsername(u.getUsername());
        r.setEmail(u.getEmail());
        r.setProfileImgUrl(u.getProfileImgUrl());
        r.setName(u.getName());
        r.setSurnames(u.getSurnames());
        r.setBirthday(u.getBirthday());
        if (u.getRole() != null) r.setRole(u.getRole().name());
        r.setCreateAt(u.getCreate_at());
        return r;
    }

}
