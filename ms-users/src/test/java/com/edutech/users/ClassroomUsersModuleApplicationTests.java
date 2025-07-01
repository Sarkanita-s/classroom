// package com.edutech.users;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class ClassroomUsersModuleApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }

package com.edutech.users;

import com.edutech.users.mapper.RoleMapper;
import com.edutech.users.mapper.RoleMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(RoleMapperImpl.class)  // Importa explícitamente la implementación generada
class ClassroomUsersModuleApplicationTests {

    @Autowired
    private RoleMapper roleMapper;  // Inyecta el mapper para verificar que está disponible

    @Test
    void contextLoads() {
        // Verifica que el contexto se carga y el mapper está disponible
        assertNotNull(roleMapper);
    }
}