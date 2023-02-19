package com.example.demo.contr;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> index() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")   //получаем id из самого url адреса
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if(employee == null) {
//            throw new NoSuchEmployeeException("There is no  employee with ID = " + id + " in DataBase");
//        }

        return employee;
    }

    //@PostMapping - откловка POST запроса
    //@RequestBody - параметр из "тела запроса"
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    //@PutMapping  - откловка PUT запроса
    //@RequestBody - параметр из "тела запроса"
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    //@DeleteMapping  - откловка DELETE запроса
    //@RequestBody    - параметр из "тела запроса"
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if(employee == null) {
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in DataBase");
//        }

        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }

}
