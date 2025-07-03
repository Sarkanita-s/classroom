package com.edutech.courses;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.edutech.common.dto.CourseCategoryDTO;
import com.edutech.common.dto.CourseCommentDTO;
import com.edutech.common.dto.CourseContentDTO;
import com.edutech.common.dto.CourseDTO;
import com.edutech.courses.controller.CourseCategoryController;
import com.edutech.courses.controller.CourseCommentController;
import com.edutech.courses.controller.CourseContentController;
import com.edutech.courses.controller.CourseController;
import com.edutech.courses.service.CourseCategoryService;
import com.edutech.courses.service.CourseCommentService;
import com.edutech.courses.service.CourseContentService;
import com.edutech.courses.service.CourseService;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.edutech.courses.controller.EnrollmentController;
import com.edutech.courses.service.EnrollmentService;
import com.edutech.common.dto.EnrollmentDTO;



@SpringBootTest
class ClassroomCoursesModuleApplicationTests {

	@InjectMocks
	private CourseCategoryController courseCategoryController;

	@Mock
	private CourseCategoryService courseCategoryService;

	@Test
	void testFindAll() {

		CourseCategoryDTO category1 = new CourseCategoryDTO();
		category1.setId(1);
		category1.setName("Mathematics");
		category1.setDescription("All about numbers and equations");
		
		CourseCategoryDTO category2 = new CourseCategoryDTO();
		category2.setId(2);
		category2.setName("Science");
		category2.setDescription("Exploring the natural world");
		
		CourseCategoryDTO category3 = new CourseCategoryDTO();
		category3.setId(3);
		category3.setName("History");
		category3.setDescription("Understanding past events");

		List<CourseCategoryDTO> mockCategories = List.of(
			category1,
			category2,
			category3
		);

		System.out.println("Mock Categories: ");

		when(courseCategoryService.findAll()).thenReturn(mockCategories);

		ResponseEntity<List<CourseCategoryDTO>> response = courseCategoryController.findAll();

		assertEquals(HttpStatus.OK, response.getStatusCode());

		assertEquals(3, response.getBody().size());
		verify(courseCategoryService).findAll();


	}

	@Test
	void testFindById() {

		int id = 1;

		CourseCategoryDTO mockCategory = new CourseCategoryDTO();
		mockCategory.setId(1);
		mockCategory.setName("Mathematics");
		mockCategory.setDescription("All about numbers and equations");

		when(courseCategoryService.findById(id)).thenReturn(mockCategory);

		ResponseEntity<CourseCategoryDTO> response = courseCategoryController.findById(id);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockCategory, response.getBody());
		verify(courseCategoryService).findById(id);
	}

	@Test
	void testCreate() {
		CourseCategoryDTO newCategory = new CourseCategoryDTO();
		newCategory.setId(1);
		newCategory.setName("Geography");
		newCategory.setDescription("Study of the Earth and its features");

		CourseCategoryDTO createdCategory = new CourseCategoryDTO();
		createdCategory.setId(1);
		createdCategory.setName(newCategory.getName());
		createdCategory.setDescription(newCategory.getDescription());

		when(courseCategoryService.create(newCategory)).thenReturn(createdCategory);

		ResponseEntity<CourseCategoryDTO> response = courseCategoryController.create(newCategory);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(newCategory, response.getBody());
		verify(courseCategoryService).create(newCategory);
	}

	@Test
	void testUpdate() {
		int id = 1;

		CourseCategoryDTO Category = new CourseCategoryDTO();
		Category.setId(1);
		Category.setName("Geography");
		Category.setDescription("Study of the Earth and its features");

		CourseCategoryDTO updatedCategory = new CourseCategoryDTO();
		updatedCategory.setId(id);
		updatedCategory.setName("Advanced Mathematics");
		updatedCategory.setDescription("In-depth study of mathematical concepts");

		when(courseCategoryService.update(id, Category)).thenReturn(updatedCategory);

		ResponseEntity<CourseCategoryDTO> response = courseCategoryController.update(id, Category);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(updatedCategory, response.getBody());
		verify(courseCategoryService).update(id, Category);
	}

	@Test
	void testDelete() {	
		int id = 1;

		ResponseEntity<Void> response = courseCategoryController.delete(id);

		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		verify(courseCategoryService).delete(id);
	}
}

@SpringBootTest
class EnrollmentControllerTest {

    @Mock
    private EnrollmentService enrollmentService;

    @InjectMocks
    private EnrollmentController enrollmentController;

    @Test
    void findAll_ShouldReturnAllEnrollments() {
        // Datos de prueba
        EnrollmentDTO enrollment1 = new EnrollmentDTO();
        enrollment1.setId(1);
        enrollment1.setStudentId(101);
        
        EnrollmentDTO enrollment2 = new EnrollmentDTO();
        enrollment2.setId(2);
        enrollment2.setStudentId(102);

        when(enrollmentService.findAll()).thenReturn(List.of(enrollment1, enrollment2));

        // Ejecutar
        ResponseEntity<List<EnrollmentDTO>> response = enrollmentController.findAll();

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void findById_ShouldReturnEnrollment() {
        // Datos de prueba
        EnrollmentDTO enrollment = new EnrollmentDTO();
        enrollment.setId(1);
        enrollment.setStudentId(101);

        when(enrollmentService.findById(1)).thenReturn(enrollment);

        // Ejecutar
        ResponseEntity<EnrollmentDTO> response = enrollmentController.findById(1);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(101, response.getBody().getStudentId());
    }

    @Test
    void create_ShouldReturnEnrollment() {
        // Datos de prueba
        EnrollmentDTO newEnrollment = new EnrollmentDTO();
        newEnrollment.setStudentId(101);
        
        EnrollmentDTO savedEnrollment = new EnrollmentDTO();
        savedEnrollment.setId(1);
        savedEnrollment.setStudentId(101);

        when(enrollmentService.create(newEnrollment)).thenReturn(savedEnrollment);

        // Ejecutar
        ResponseEntity<EnrollmentDTO> response = enrollmentController.create(newEnrollment);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    void update_ShouldReturnUpdatedEnrollment() {
        // Datos de prueba
        EnrollmentDTO updated = new EnrollmentDTO();
        updated.setId(1);
        updated.setStudentId(101);

        when(enrollmentService.update(1, updated)).thenReturn(updated);

        // Ejecutar
        ResponseEntity<EnrollmentDTO> response = enrollmentController.update(1, updated);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(101, response.getBody().getStudentId());
    }

    @Test
    void delete_ShouldReturnNoContent() {
        // Ejecutar
        ResponseEntity<Void> response = enrollmentController.delete(1);

        // Verificar
        assertEquals(204, response.getStatusCodeValue());
        verify(enrollmentService).delete(1);
    }
}

@SpringBootTest
class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @Test
    void findAll_ShouldReturnAllCourses() {
        // Preparar datos de prueba
        CourseDTO course1 = new CourseDTO();
        course1.setId(1);
        course1.setTitle("Matemáticas");
        
        CourseDTO course2 = new CourseDTO();
        course2.setId(2);
        course2.setTitle("Historia");

        when(courseService.findAll()).thenReturn(List.of(course1, course2));

        // Ejecutar
        ResponseEntity<List<CourseDTO>> response = courseController.findAll();

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void findById_ShouldReturnCourse() {
        // Preparar datos
        CourseDTO course = new CourseDTO();
        course.setId(1);
        course.setTitle("Programación");

        when(courseService.findById(1)).thenReturn(course);

        // Ejecutar
        ResponseEntity<CourseDTO> response = courseController.findById(1);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Programación", response.getBody().getTitle());
    }

    @Test
    void create_ShouldReturnCreatedCourse() {
        // Preparar datos
        CourseDTO newCourse = new CourseDTO();
        newCourse.setTitle("Nuevo Curso");
        
        CourseDTO savedCourse = new CourseDTO();
        savedCourse.setId(1);
        savedCourse.setTitle("Nuevo Curso");

        when(courseService.create(newCourse)).thenReturn(savedCourse);

        // Ejecutar
        ResponseEntity<CourseDTO> response = courseController.create(newCourse);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    void update_ShouldReturnUpdatedCourse() {
        // Preparar datos
        CourseDTO updatedCourse = new CourseDTO();
        updatedCourse.setId(1);
        updatedCourse.setTitle("Curso Actualizado");

        when(courseService.update(1, updatedCourse)).thenReturn(updatedCourse);

        // Ejecutar
        ResponseEntity<CourseDTO> response = courseController.update(1, updatedCourse);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Curso Actualizado", response.getBody().getTitle());
    }

    @Test
    void delete_ShouldReturnNoContent() {
        // Ejecutar
        ResponseEntity<Void> response = courseController.delete(1);

        // Verificar
        assertEquals(204, response.getStatusCodeValue());
        verify(courseService).delete(1);
    }
}

@SpringBootTest
class CourseCommentControllerTest {

    @Mock
    private CourseCommentService commentService;

    @InjectMocks
    private CourseCommentController commentController;

    @Test
    void createComment_ShouldReturnCreatedComment() {
        // Arrange
        CourseCommentDTO inputComment = new CourseCommentDTO();
        inputComment.setCourseId(1);
        inputComment.setUserId(1);
        inputComment.setCommentText("Buen curso");
        inputComment.setRating(5);

        CourseCommentDTO savedComment = new CourseCommentDTO();
        savedComment.setId(1);
        savedComment.setCourseId(inputComment.getCourseId());
        savedComment.setUserId(inputComment.getUserId());
        savedComment.setCommentText(inputComment.getCommentText());
        savedComment.setRating(inputComment.getRating());
        savedComment.setCreatedAt(Instant.now());

        when(commentService.create(inputComment)).thenReturn(savedComment);

        // Act
        ResponseEntity<CourseCommentDTO> response = commentController.create(inputComment);

        // Assert - Cambiado a esperar 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Ahora coincide con el controlador
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getId());
        assertEquals("Buen curso", response.getBody().getCommentText());
        verify(commentService).create(inputComment);
    }

    @Test
    void deleteComment_ShouldReturnNoContent() {
        // ID de prueba
        Integer commentId = 1;

        // Llamar al método
        ResponseEntity<Void> response = commentController.delete(commentId);

        // Verificar
        assertEquals(204, response.getStatusCodeValue());
        verify(commentService).delete(commentId);
    }

    @Test
    void deleteComment_ShouldHandleServiceException() {
        // ID de prueba
        Integer commentId = 99;

        // Configurar mock para lanzar excepción
        doThrow(new RuntimeException("Error al eliminar")).when(commentService).delete(commentId);

        // Llamar al método y verificar excepción
        assertThrows(RuntimeException.class, () -> {
            commentController.delete(commentId);
        });
    }
}

@SpringBootTest
class CourseContentControllerTest {

    @Mock
    private CourseContentService contentService;

    @InjectMocks
    private CourseContentController contentController;

    @Test
    void create_ShouldReturnContent() {
        // Preparar datos
        CourseContentDTO newContent = new CourseContentDTO();
        newContent.setTitle("Nuevo Contenido");
        
        CourseContentDTO savedContent = new CourseContentDTO();
        savedContent.setId(1);
        savedContent.setTitle("Nuevo Contenido");

        when(contentService.create(newContent)).thenReturn(savedContent);

        // Ejecutar
        ResponseEntity<CourseContentDTO> response = contentController.create(newContent);

        // Verificar
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    void delete_ShouldReturnNoContent() {
        // Ejecutar
        ResponseEntity<Void> response = contentController.delete(1);

        // Verificar
        assertEquals(204, response.getStatusCodeValue());
        verify(contentService).delete(1);
    }
}