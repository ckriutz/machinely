package com.example.ak.apm.apmdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void executeQuery() {
        employeeRepository.executeLongRunningQuery();
        // Simulate idle in transaction by not committing immediately
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findByNameIgnoreCase(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    public List<Employee> getEmployeesByWildcardName(String wildcardName) {
        return employeeRepository.getEmployeesByWildcardName(wildcardName);
    }

}