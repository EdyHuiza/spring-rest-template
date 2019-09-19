package com.rootnite.template.springrest.service.rrhh;

import com.rootnite.template.springrest.controller.dto.EmployeeRequestDto;
import com.rootnite.template.springrest.model.entity.rrhh.Employee;

import java.util.List;

public interface EmployeeService {

    Employee persist(EmployeeRequestDto employeeRequestDto);

    Employee update(EmployeeRequestDto employeeRequestDto);

    Employee get(long id);

    List<Employee> findAll();

    void delete(long id);
}
