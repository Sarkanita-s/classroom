package com.edutech.support.service;

import com.edutech.common.dto.SupportTicketDTO;
import com.edutech.support.client.UserClient;
import com.edutech.support.entity.SupportTicket;
import com.edutech.support.mapper.SupportTicketMapper;
import com.edutech.support.repository.SupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static com.edutech.common.exception.ExceptionUtils.orThrow;
import static com.edutech.common.exception.ExceptionUtils.orThrowFeign;

@Service
@RequiredArgsConstructor
public class SupportTicketService {

    private final SupportTicketRepository ticketRepo;
    private final SupportTicketMapper ticketMapper;
    private final UserClient userClient;

    public List<SupportTicketDTO> findAll() {
        return ticketRepo.findAll().stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SupportTicketDTO findById(Integer id) {
        return ticketMapper.toDTO(orThrow(ticketRepo.findById(id), "Ticket de soporte"));
    }

    public SupportTicketDTO create(SupportTicketDTO dto) {
        // Validar que el usuario existe
        orThrowFeign(dto.getUserId(), userClient::findById, "Usuario");
        
        // Si tiene soporte asignado, validar que existe
        if (dto.getSupportUserId() != null) {
            orThrowFeign(dto.getSupportUserId(), userClient::findById, "Usuario de soporte");
        }
        
        SupportTicket entity = ticketMapper.toEntity(dto);
        entity.setCreatedAt(Instant.now());
        entity.setStatus("OPEN"); // Estado inicial
        
        return ticketMapper.toDTO(ticketRepo.save(entity));
    }

    public SupportTicketDTO update(Integer id, SupportTicketDTO dto) {
        SupportTicket existing = orThrow(ticketRepo.findById(id), "Ticket de soporte");
        
        // Validar usuarios si se modifican
        if (!existing.getUser().equals(dto.getUserId())) {
            orThrowFeign(dto.getUserId(), userClient::findById, "Usuario");
        }
        
        if (dto.getSupportUserId() != null && 
            (existing.getSupportUser() == null || !existing.getSupportUser().equals(dto.getSupportUserId()))) {
            orThrowFeign(dto.getSupportUserId(), userClient::findById, "Usuario de soporte");
        }
        
        SupportTicket entity = ticketMapper.toEntity(dto);
        entity.setId(id);
        entity.setCreatedAt(existing.getCreatedAt());
        
        // Si se cierra el ticket
        if ("CLOSED".equals(dto.getStatus()) && !"CLOSED".equals(existing.getStatus())) {
            entity.setClosedAt(Instant.now());
        }
        
        return ticketMapper.toDTO(ticketRepo.save(entity));
    }

    public void delete(Integer id) {
        ticketRepo.delete(orThrow(ticketRepo.findById(id), "Ticket de soporte"));
    }
}