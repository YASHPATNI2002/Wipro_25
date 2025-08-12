package com.wipro.mvcspring.controller;

import com.wipro.mvcspring.dto.DtoMobile;
import com.wipro.mvcspring.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService service;

    @PostMapping
    public String createMobile(@RequestBody DtoMobile mobile) {
        return service.createMobile(mobile);
    }

    @GetMapping("/{id}")
    public DtoMobile getMobile(@PathVariable int id) {
        return service.getMobile(id);
    }

    @PutMapping
    public String updateMobile(@RequestBody DtoMobile mobile) {
        return service.updateMobile(mobile);
    }

    @DeleteMapping("/{id}")
    public String deleteMobile(@PathVariable int id) {
        return service.deleteMobile(id);
    }
}
