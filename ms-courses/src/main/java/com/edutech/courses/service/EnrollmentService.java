package com.edutech.courses.service;

import com.edutech.common.dto.EnrollmentDTO;
import com.edutech.courses.client.UserClient;
import com.edutech.courses.entity.Enrollment;
import com.edutech.courses.mapper.EnrollmentMapper;
import com.edutech.courses.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    
    @Autowired
    private EnrollmentRepository enrollmentRepo;
    
    @Autowired
    private EnrollmentMapper enrollmentMapper;
    
    @Autowired
    private UserClient userClient;


    public List<EnrollmentDTO> findAll() {
        return enrollmentRepo.findAll().stream().map(enrollmentMapper::toDTO).toList();
    }
    public EnrollmentDTO findById(Integer id) {
        return enrollmentMapper.toDTO(orThrow(enrollmentRepo.findById(id), "Inscripcion"));
    }


    public EnrollmentDTO create(EnrollmentDTO dto) {

        orThrowFeign(dto.getStudentId(), userClient::findById, "Estudiante");
        orThrowFeign(dto.getCourseId(), userClient::findById, "Curso");

        return saveDTO(dto, null); // id = null porque es creación
    }

    public EnrollmentDTO update(Integer id, EnrollmentDTO dto) {
        orThrow(enrollmentRepo.findById(id), "Inscripcion");
        return saveDTO(dto, id);
    }

    public void delete(Integer id) {
        enrollmentRepo.delete(orThrow(enrollmentRepo.findById(id), "Inscripcion"));
    }

    private EnrollmentDTO saveDTO(EnrollmentDTO dto, Integer id) {
        Enrollment entity = enrollmentMapper.toEntity(dto);
        if (id != null) entity.setId(id);
        return enrollmentMapper.toDTO(enrollmentRepo.save(entity));
   }
}
