package com.rootnite.template.springrest.model.repository.rrhh;

import com.rootnite.template.springrest.model.entity.rrhh.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
