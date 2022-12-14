package com.nimoh.hotel.service.user;

import com.nimoh.hotel.dto.user.UserResponse;
import com.nimoh.hotel.dto.user.UserSignUpRequest;

public interface UserService {
    public UserResponse signUp(UserSignUpRequest request);
    public boolean deleteById(Long userId);
}
