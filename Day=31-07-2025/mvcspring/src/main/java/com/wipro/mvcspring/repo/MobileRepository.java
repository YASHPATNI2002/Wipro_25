package com.wipro.mvcspring.repo;

import com.wipro.mvcspring.dto.DtoMobile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MobileRepository {
    private final Map<Integer, DtoMobile> database = new HashMap<>();

    public void save(DtoMobile mobile) {
        database.put(mobile.getId(), mobile);
    }

    public DtoMobile findById(int id) {
        return database.get(id);
    }

    public void update(DtoMobile mobile) {
        database.put(mobile.getId(), mobile);
    }

    public void delete(int id) {
        database.remove(id);
    }
}
