package com.rootnite.template.springrest.controller;

import com.rootnite.template.springrest.controller.dto.EmployeeRequestDto;
import com.rootnite.template.springrest.model.entity.rrhh.Employee;
import com.rootnite.template.springrest.service.rrhh.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping("/employees")
    public ResponseEntity<?> listAll() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Employee> list = employeeService.findAll();
            response.put("message", "Se ha obtenido " + list.size() + " registros");
            response.put("employees", list);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al momento de listar los empleados del sistema", e);
            e.printStackTrace();
            response.put("message", "Error en el servidor");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Employee employee = employeeService.get(id);
            if (employee != null) {
                response.put("message", "Empleado obtenido con exito!");
                response.put("employee", employee);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "No se ha encontrado el empleado con id: " + id);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            response.put("message", "Error al eliminar el empleado de la base de datos");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("employees")
    public ResponseEntity<?> persistEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        try {
            Map<String, Object> response = new HashMap<>();
            Employee employee = employeeService.persist(employeeRequestDto);
            response.put("message", "Se ha registrado correctamente la compra de la accion.");
            response.put("id", employee.getId());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error al momento de crear el registro de empleado", e);
            e.printStackTrace();
            return new ResponseEntity<>(new HashMap<>().put("message", "Error en el servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("employees")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        try {
            Map<String, Object> response = new HashMap<>();
            employeeService.update(employeeRequestDto);
            response.put("message", "Se ha actualizado correctamente el registro.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al momento de crear el registro de empleado", e);
            e.printStackTrace();
            return new ResponseEntity<>(new HashMap<>().put("message", "Error en el servidor"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            employeeService.delete(id);
            response.put("message", "Se ha eliminado con éxito el registro!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al eliminar el empleado de la base de datos");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
