package com.devsuperior.dbs02.services;

import com.devsuperior.dbs02.dto.EventDTO;
import com.devsuperior.dbs02.entities.City;
import com.devsuperior.dbs02.entities.Event;
import com.devsuperior.dbs02.repositories.EventRepository;
import com.devsuperior.dbs02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            var entity = repository.getReferenceById(id);
            CopyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void CopyDtoToEntity(EventDTO eventDTO, Event event) {
        event.setName(eventDTO.getName());
        event.setCity(new City(eventDTO.getCityId(), null));
        event.setDate(eventDTO.getDate());
        event.setUrl(eventDTO.getUrl());
    }
}
