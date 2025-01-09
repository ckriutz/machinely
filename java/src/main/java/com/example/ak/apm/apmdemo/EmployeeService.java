package com.example.ak.apm.apmdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional()
    public void executeQuery() {
        employeeRepository.executeLongRunningQuery();
        // Simulate idle in transaction by not committing immediately
    }
    
}
