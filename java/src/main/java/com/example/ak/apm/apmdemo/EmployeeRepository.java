package com.example.ak.apm.apmdemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByNameIgnoreCase(String name);

    //can you do a find by method by employee ID
    public Employee findByEmployeeID(int employeeID);

    //can you do a find by method by position
    public List<Employee> findByPosition(String position);

    @Query(value = "SELECT long_running_query()", nativeQuery = true)
    public void executeLongRunningQuery();


}