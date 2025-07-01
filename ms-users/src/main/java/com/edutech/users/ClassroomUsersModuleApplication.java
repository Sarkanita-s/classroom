// package com.edutech.users;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.openfeign.EnableFeignClients;

// @EnableDiscoveryClient
// @EnableFeignClients(basePackages = "com.edutech.users.client")
// @SpringBootApplication
// public class ClassroomUsersModuleApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(ClassroomUsersModuleApplication.class, args);
// 	}

// }

package com.edutech.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {
    "com.edutech.users",
    "com.edutech.common" // Si usas componentes del módulo common
})
public class ClassroomUsersModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassroomUsersModuleApplication.class, args);
    }
}