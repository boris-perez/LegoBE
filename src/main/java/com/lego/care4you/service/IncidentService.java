package com.lego.care4you.service;

import com.lego.care4you.domain.Incident;
import com.lego.care4you.dto.IncidentRequestDTO;
import com.lego.care4you.repository.EmployeeRepository;
import com.lego.care4you.repository.IncidentRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricardo.veizaga
 */
@Service
public class IncidentService extends GenericService<Incident, IncidentRequestDTO> {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident findById(String id) {
        return incidentRepository.findOne(id);
    }

    @Override
    public Incident delete(String id) {
        Incident incident = findById(id);
        incidentRepository.delete(incident);
        return incident;
    }

    @Override
    public Incident insert(IncidentRequestDTO dto) {
        Incident incident = buildCreateIncident(dto);
        incident = incidentRepository.insert(incident);
        return incident;
    }

    @Override
    public Incident update(String id, IncidentRequestDTO dto) {
        Incident incident = findById(id);
        buildUpdateIncident(incident, dto);
        incident = incidentRepository.insert(incident);
        return incident;
    }

    private Incident buildCreateIncident(IncidentRequestDTO dto) {
        Incident incident = new Incident();
        incident.setIncidentName(dto.getIncidentName());
        incident.setIncidentCode(dto.getIncidentCode());
        incident.setIncidentType(dto.getIncidentType());
        incident.setIncidentScope(dto.getIncidentScope());
        incident.setIncidentObjective(dto.getIncidentObjective());
        incident.setIncidentCriteria(dto.getIncidentCriteria());
        incident.setIncidentPeriodicity(dto.getIncidentPeriodicity());
        incident.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));

        return incident;
    }

    private void buildUpdateIncident(Incident incident, IncidentRequestDTO dto) {
        incident.setIncidentName(dto.getIncidentName());
        incident.setIncidentType(dto.getIncidentType());
        incident.setIncidentCode(dto.getIncidentCode());
        incident.setIncidentScope(dto.getIncidentScope());
        incident.setIncidentCriteria(dto.getIncidentCriteria());
        incident.setIncidentObjective(dto.getIncidentObjective());
        incident.setIncidentPeriodicity(dto.getIncidentPeriodicity());
        incident.setEmployee(employeeRepository.findOne(dto.getEmployeeId()));
    }
}
