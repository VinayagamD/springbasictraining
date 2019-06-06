package com.vinaylogics.springbasictraining.services.impl;

import com.vinaylogics.springbasictraining.domains.Employee;
import com.vinaylogics.springbasictraining.repositories.EmployeeRepository;
import com.vinaylogics.springbasictraining.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }
}
