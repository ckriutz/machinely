package com.example.ak.apm.apmdemo;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2023-10-01");

        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setPosition("Developer");
        employee1.setStartDate(date);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setPosition("Manager");
        employee2.setStartDate(date);
        employeeRepository.save(employee2);
    }

    @AfterEach
    public void tearDown() throws Exception {
        employeeRepository.deleteAll();
    }

    @Test
    public void testFindByNameIgnoreCase() {
        List<Employee> employees = employeeRepository.findByNameIgnoreCase("john doe");
        assertThat(employees).isNotEmpty();
    }

    @Test
    public void testFindByPosition() {
        List<Employee> employees = employeeRepository.findByPosition("Developer");
        assertThat(employees).isNotEmpty();
    }
}