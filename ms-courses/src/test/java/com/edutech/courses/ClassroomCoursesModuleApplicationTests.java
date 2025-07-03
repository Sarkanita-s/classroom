package com.edutech.courses;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.edutech.common.dto.CourseCategoryDTO;
import com.edutech.courses.controller.CourseCategoryController;
import com.edutech.courses.service.CourseCategoryService;


import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
