package com.edutech.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.edutech.common.dto.SupportTicketDTO;

import java.util.List;

@FeignClient(name = "ms-support")
public interface SupportClient {
    
    @GetMapping("/api/support-tickets/user/{userId}")
    List<SupportTicketDTO> findTicketsByUser(@PathVariable("userId") Integer userId);
    
    @GetMapping("/api/support-tickets/assigned/{supportUserId}")
    List<SupportTicketDTO> findAssignedTickets(@PathVariable("supportUserId") Integer supportUserId);
}