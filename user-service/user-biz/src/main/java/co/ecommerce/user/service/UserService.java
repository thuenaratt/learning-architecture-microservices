package co.ecommerce.user.service;

import co.ecommerce.user.dto.UserCreateRequest;
import co.ecommerce.user.dto.UserResponse;
import co.ecommerce.user.dto.UserUpdateRequest;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);
}
