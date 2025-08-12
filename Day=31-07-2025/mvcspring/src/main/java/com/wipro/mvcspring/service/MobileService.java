package com.wipro.mvcspring.service;

import com.wipro.mvcspring.dto.DtoMobile;
import com.wipro.mvcspring.repo.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {

    @Autowired
    private MobileRepository repository;

    public String createMobile(DtoMobile mobile) {
        repository.save(mobile);
        return "Mobile created with ID: " + mobile.getId();
    }

    public DtoMobile getMobile(int id) {
        return repository.findById(id);
    }

    public String updateMobile(DtoMobile mobile) {
        repository.update(mobile);
        return "Mobile updated with ID: " + mobile.getId();
    }

    public String deleteMobile(int id) {
        repository.delete(id);
        return "Mobile deleted with ID: " + id;
    }
}
