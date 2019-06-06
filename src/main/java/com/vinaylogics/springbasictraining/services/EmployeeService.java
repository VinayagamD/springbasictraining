package com.vinaylogics.springbasictraining.services;

import com.vinaylogics.springbasictraining.domains.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee get(Long id);

    Employee save(Employee employee);

    Employee update(Employee employee);
    

}
