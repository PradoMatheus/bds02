package com.devsuperior.dbs02.resources;

import com.devsuperior.dbs02.dto.EventDTO;
import com.devsuperior.dbs02.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

    @Autowired
    private EventService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable(value = "id") Long id, @RequestBody EventDTO eventDTO) {
        var dto = service.update(id, eventDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
