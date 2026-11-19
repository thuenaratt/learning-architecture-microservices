package co.ecommerce.customer.restapi.controller;

import co.ecommerce.customer.client.dto.UserResponse;
import co.ecommerce.customer.client.feign.UserFeignClient;
import co.ecommerce.customer.restapi.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerQueryController {

    private final UserFeignClient userFeignClient;

    @GetMapping
    public CustomerResponse getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "25") int size

    ){
        return null;
    }

    @GetMapping("/check-user/{userId}")
    public UserResponse checkUser(@PathVariable String userId){
        return userFeignClient.getById(userId);

    }


}
