package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.Audit;
import com.ecommerce.ecommerce.repository.AuditRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public Audit createAudit(Audit audit) {
        return auditRepository.save(audit);
    }

    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    public Optional<Audit> getAuditById(Long id) {
        return auditRepository.findById(id);
    }
}
