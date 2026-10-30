package co.ecommerce.user.service;

import co.ecommerce.user.dto.UserCreateRequest;
import co.ecommerce.user.dto.UserResponse;
import co.ecommerce.user.dto.UserUpdateRequest;
import java.util.List;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);

    List<UserResponse> getUsersByRoleName(String roleName);

    List<UserResponse> getUsers();

    UserResponse getUserByUsername(String username);

    void delete(String id);
}
