package com.example.ak.apm.apmdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HttpController.class)
public class HttpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private EmployeeService employeeService;

    @InjectMocks
    private HttpController httpController;

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("2023-10-01");

        employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setPosition("Developer");
        employee1.setStartDate(date);

        employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setPosition("Manager");
        employee2.setStartDate(date);
    }

    @Test
    public void testGetMethodName() throws Exception {
        mockMvc.perform(get("/").param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello John"));
    }

    @Test
    public void testPostMethodName() throws Exception {
        mockMvc.perform(post("/employee")
                .param("name", "John Doe")
                .param("position", "Developer")
                .param("startDate", "2023-10-01"))
                .andExpect(status().isOk())
                .andExpect(content().string("employee John Doe Developer 2023-10-01"));
    }


    @Test
    public void testGetEmployees2() throws Exception {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].position").value("Developer"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"))
                .andExpect(jsonPath("$[1].position").value("Manager"));
    }


    @Test
    public void testGetJsonPayload() throws Exception {
        mockMvc.perform(get("/httpbin"))
                .andExpect(status().isOk());
    }

}