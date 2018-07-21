package com.co.intrasoft.fixedassets.service;

import com.co.intrasoft.fixedassets.exceptions.InconsistentDataException;
import com.co.intrasoft.fixedassets.exceptions.NotFoundException;
import com.co.intrasoft.fixedassets.model.Area;
import com.co.intrasoft.fixedassets.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaService.class);

    @Autowired
    private AreaRepository areaRepository;

    public Area createArea(Area area) {
        Optional<Area> optionalArea = areaRepository.findByCity(area.getCity());
        if (optionalArea.isPresent()) {
            throw new InconsistentDataException("La ciudad ya ha sido asignada a una area");
        }
        return areaRepository.save(area);
    }

    public Area updateArea(Area area) {
        return areaRepository.save(area);
    }

    public List<Area> getAreas() {
        return areaRepository.findAll();
    }

    public Optional<Area> getArea(String id) {
        return areaRepository.findById(id);
    }

    public void deleteArea(String id) {
        Optional<Area> optionalArea = areaRepository.findById(id);
        if (!optionalArea.isPresent()) {
            throw new NotFoundException();
        }
        areaRepository.deleteById(id);
    }

}
