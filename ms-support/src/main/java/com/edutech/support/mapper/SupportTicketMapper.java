package com.edutech.support.mapper;

import com.edutech.common.dto.SupportTicketDTO;
import com.edutech.support.entity.SupportTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupportTicketMapper {
    @Mapping(source = "user", target = "userId")
    @Mapping(source = "supportUser", target = "supportUserId")
    SupportTicketDTO toDTO(SupportTicket entity);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "supportUserId", target = "supportUser")
    SupportTicket toEntity(SupportTicketDTO dto);
}