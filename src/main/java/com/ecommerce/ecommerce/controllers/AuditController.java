package com.ecommerce.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.ecommerce.models.Audit;
import com.ecommerce.ecommerce.models.User;
import com.ecommerce.ecommerce.payload.AuditDTO;
import com.ecommerce.ecommerce.service.AuditService;
import com.ecommerce.ecommerce.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Audit createAudit(@RequestBody AuditDTO auditRequestDTO) {
        Audit audit = new Audit();
        audit.setDescription(auditRequestDTO.getDescription());

        User user = userService.getUserById(auditRequestDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        audit.setUser(user);
        return auditService.createAudit(audit);
    }

    @GetMapping
    public List<Audit> getAllAudits() {
        return auditService.getAllAudits();
    }

    @GetMapping("/{id}")
    public Optional<Audit> getAuditById(@PathVariable Long id) {
        return auditService.getAuditById(id);
    }
}
