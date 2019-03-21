package com.lego.care4you.service;

import com.lego.care4you.domain.Position;
import com.lego.care4you.dto.PositionRequestDTO;
import com.lego.care4you.repository.PositionRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class PositionService extends GenericService<Position, PositionRequestDTO> {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(String id) {
        return positionRepository.findOne(id);
    }

    @Override
    public Position delete(String id) {
        Position position = findById(id);
        positionRepository.delete(position);

        return position;
    }

    @Override
    public Position insert(PositionRequestDTO dto) {
        Position position = buildCreatePosition(dto);
        position = positionRepository.insert(position);

        return position;
    }

    @Override
    public Position update(String id, PositionRequestDTO dto) {
        Position position = findById(id);
        buildUpdatePosition(position, dto);

        positionRepository.insert(position);
        return position;
    }

    private Position buildCreatePosition(PositionRequestDTO dto) {
        Position position = new Position();
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());
        position.setDateStart(new Date());
        position.setDateEnd(new Date());

        return position;
    }

    private void buildUpdatePosition(Position position, PositionRequestDTO dto) {
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());

    }
}
