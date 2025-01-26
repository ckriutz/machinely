package com.example.ak.apm.apmdemo;

import org.springframework.web.bind.annotation.RestController;

//import jakarta.jms.BytesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//import org.springframework.jms.core.JmsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//import com.azure.core.annotation.PathParam;



@RestController
public class HttpController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //inject EmployeeService

    @Autowired
    private EmployeeService employeeService;



    //@Autowired
    //private JmsTemplate jmsTemplate;

    private static final String QUEUE_NAME = "empq1";

    // create a logger using java.util.logging
    private static final Logger log = Logger.getLogger(HttpController.class.getName());

    /**
     * Handles the HTTP GET request to say hello to a person.
     *
     * @param name the name of the person
     * @return a greeting message
     */
    @GetMapping("/")
    public String getMethodName(@RequestParam String name) {
        log.info("Saying hello to: " + name);
        return "hello " + name;
    }

    /**
     * Handles the HTTP POST request to add a new employee.
     *
     * @param name the name of the employee
     * @param position the position of the employee
     * @param startDate the start date of the employee in the format "yyyy-MM-dd"
     * @return a confirmation message containing the employee's name, position, and start date
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/employee")
    public String postMethodName(@RequestParam String name, @RequestParam String position,
            @RequestParam String startDate) {

        log.info("Adding employee: " + name + " " + position + " " + startDate);

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);

        Date date = parseDate(startDate);
        employee.setStartDate(date);

        employeeService.saveEmployee(employee);

        log.info("Employee added: " + employee.toString());
        return "employee " + name + " " + position + " " + startDate;
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            log.severe(e.getMessage());
            e.printStackTrace();
        }
        return date;
    }

    //do a get mapping that finds and employee by name and returns the response in JSOn format
    
    @CrossOrigin(origins = "*")  
    @GetMapping(path = "/employee", produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployee(@RequestParam String name) {
        // return employee by name
        // read from database using EmployeeRepository
        log.info("Getting employee by name: " + name);
        List<Employee> employees = employeeService.findByNameIgnoreCase(name);
        //return employee as a JSON response
        return ResponseEntity.ok(employees);
    }   


    @CrossOrigin(origins = "*")    
    @GetMapping(path="/employees", produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployees2() {
        log.info("Getting all employees");
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @CrossOrigin(origins = "*")  
    @GetMapping("/random")
    public String getException(@RequestParam int num) {
        // return exception if num > 50
        if (num > 50) {
            log.severe("Exception occurred");
            throw new RuntimeException("Number is greater than 50");
        }
        log.finest("Number is less than 50: " + num);
        return "Number is less than 50: " + num;
    }

    @CrossOrigin(origins = "*")  
    @GetMapping(path = "/httpbin", produces = "application/json")
    public String getJsonPayload() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://httpbin.org/json";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCodeValue() == 200) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusCode());
        }
    }

    //create a simple hello world endpoint that returns a string and takes in a path paremeter 
    // so that it can be tested with different values and simply returns teh value sent it to
    // the endpoint /api/employee/echo/{value}
    @CrossOrigin(origins = "*")
    @GetMapping("/api/employee/echo/{value}")
    public String echo(@Param("value") String value) {
        log.info("Echoing: " + value);
        return value;
    }

    //



}
