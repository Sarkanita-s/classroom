package com.edutech.payments.client;

import com.edutech.common.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-users")
public interface UserClient {
    @GetMapping("/api/users/{id}")
    UserDTO findById(@PathVariable Integer id);
}