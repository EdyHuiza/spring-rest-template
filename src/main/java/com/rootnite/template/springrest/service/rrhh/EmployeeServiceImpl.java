package com.rootnite.template.springrest.service.rrhh;

import com.rootnite.template.springrest.controller.dto.EmployeeRequestDto;
import com.rootnite.template.springrest.model.entity.rrhh.Employee;
import com.rootnite.template.springrest.model.repository.rrhh.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee persist(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDto.getName());
        employee.setDocument(employeeRequestDto.getDocument());
        employee.setDocumentExt(employeeRequestDto.getDocumentExt());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee update(EmployeeRequestDto employeeRequestDto) {
        Employee employee = get(employeeRequestDto.getId());
        employee.setName(employeeRequestDto.getName());
        employee.setDocument(employeeRequestDto.getDocument());
        employee.setDocumentExt(employeeRequestDto.getDocumentExt());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee get(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(get(id));
    }
}
