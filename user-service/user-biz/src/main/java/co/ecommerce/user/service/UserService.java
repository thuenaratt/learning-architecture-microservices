package co.ecommerce.user.service;

import co.ecommerce.restapi.exception.dto.PageResponse;
import co.ecommerce.user.dto.UserCreateRequest;
import co.ecommerce.user.dto.UserResponse;
import co.ecommerce.user.dto.UserUpdateRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
//    UserResponse create(UserCreateRequest userCreateRequest);
//
//    UserResponse update(String id, UserUpdateRequest userUpdateRequest);
//
//    UserResponse getById(String id);
//
//    List<UserResponse> getUsersByRoleName(String roleName);
//
//    List<UserResponse> getUsers();
//
//    UserResponse getUserByUsername(String username);
//
//    void delete(String id);

    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);

    void deleteById(String id);

    UserResponse getByUsername(String username);

    PageResponse<UserResponse> getUsersByRoleName(String roleName, Pageable pageable);

    PageResponse<UserResponse> getUsers(PageRequest of);

}
