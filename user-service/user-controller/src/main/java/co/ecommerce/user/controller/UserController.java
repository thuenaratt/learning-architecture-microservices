package co.ecommerce.user.controller;

import co.ecommerce.user.dto.UserCreateRequest;
import co.ecommerce.user.dto.UserResponse;
import co.ecommerce.user.dto.UserUpdateRequest;
import co.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse create(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }

    @PatchMapping("/{id}")
    public UserResponse update(@PathVariable String id,
                               @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.update(id, userUpdateRequest);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/roles/{roleName}")
    public List<UserResponse> getUsersByRoleName(@PathVariable String roleName) {
        return userService.getUsersByRoleName(roleName);
    }

    @GetMapping("/username/{username}")
    public UserResponse getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public java.util.Map<String, String> delete(@PathVariable String id) {
        userService.delete(id);
        return java.util.Map.of("message", "User deleted successfully");
    }

}
