package com.co.intrasoft.fixedassets.controllers;

import com.co.intrasoft.fixedassets.model.Area;
import com.co.intrasoft.fixedassets.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/area", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = "*")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping(
            consumes = { "application/json", "text/xml" },
            produces = { "application/json", "text/xml" }
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Area createArea(@RequestBody Area area) {
        // TODO: Validate that area to create doesn't have ID
        return areaService.createArea(area);
    }

    @GetMapping(
            produces = { "application/json", "text/xml" }
    )
    public List<Area> getAreas() {
        return areaService.getAreas();
    }

    @GetMapping(
            path = "/{areaId}",
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    public ResponseEntity<Area> getArea(@PathVariable("areaId") String areaId) {
        Optional<Area> optArea = areaService.getArea(areaId);
        if (optArea.isPresent()) {
            return new ResponseEntity<>(optArea.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Area>(new Area(), HttpStatus.NOT_FOUND);
    }

    @PutMapping(
            path = "/{areaId}",
            consumes = { "application/json", "text/xml" },
            produces = { "application/json", "text/xml" }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Area updateArea(@PathVariable("areaId") String areaId, @RequestBody Area area) {
        return areaService.updateArea(area);
    }

    @DeleteMapping(
            path = "/{areaId}",
            produces = { "application/json", "text/xml" },
            consumes = { "application/json", "text/xml" }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArea(@PathVariable("areaId") String areaId) {
        try {
            areaService.deleteArea(areaId);
        } catch (EmptyResultDataAccessException e) { }
    }

}
