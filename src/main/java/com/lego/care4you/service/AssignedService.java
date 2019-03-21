package com.lego.care4you.service;

import com.lego.care4you.domain.Assigned;
import com.lego.care4you.domain.Position;
import com.lego.care4you.dto.AssignedRequestDTO;
import com.lego.care4you.repository.AssignedRepository;
import com.lego.care4you.repository.DepartmentRepository;
import com.lego.care4you.repository.PositionRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class AssignedService extends GenericService<Assigned, AssignedRequestDTO> {

    @Autowired
    private AssignedRepository assignedRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Assigned> findAll() {
        return assignedRepository.findAll();
    }

    @Override
    public Assigned findById(String id) {
        return assignedRepository.findOne(id);
    }

    @Override
    public Assigned delete(String id) {
        Assigned assigned = findById(id);
        assignedRepository.delete(assigned);
        return assigned;
    }

    @Override
    public Assigned insert(AssignedRequestDTO dto) {
        Assigned assigned = buildCreateAssigned(dto);
        assigned = assignedRepository.insert(assigned);
        return assigned;
    }

    @Override
    public Assigned update(String id, AssignedRequestDTO dto) {
        Assigned assigned = findById(id);
        buildUpdateAssigned(assigned, dto);
        assigned = assignedRepository.insert(assigned);
        return assigned;
    }

    private Assigned buildCreateAssigned(AssignedRequestDTO dto) {
        Assigned assigned = new Assigned();
        assigned.setStateAssigned(dto.getStateAssigned());
        assigned.setPosition(positionRepository.findOne(dto.getPositionId()));
        assigned.setDepartment(departmentRepository.findOne(dto.getDepartmentId()));

        return assigned;
    }

    private void buildUpdateAssigned(Assigned assigned, AssignedRequestDTO dto){
        assigned.setStateAssigned(dto.getStateAssigned());
        assigned.setPosition(positionRepository.findOne(dto.getPositionId()));
        assigned.setDepartment(departmentRepository.findOne(dto.getDepartmentId()));
    }
}
