package com.edts.employee.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.edts.employee.model.dto.response.EmployeeRes;
import com.edts.employee.model.dto.response.ResponseSchema;
import com.edts.employee.model.entity.Grade;
import com.edts.employee.repository.EmployeeRepository;
import com.edts.employee.repository.GradeRepository;
import com.edts.employee.service.EmployeeService;
import com.edts.employee.service.ResponseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    EmployeeService employeeService;
    
    @MockBean
    ResponseService responseService;
    
    @MockBean
    EmployeeRepository employeeRepository;
    
    @MockBean
    GradeRepository gradeRepository;
    
    Grade manager = new Grade(1L, 1L, "Manager", 10L);
    
    EmployeeRes Record_1_res = new EmployeeRes(10001L, "Jonah", manager, 7563000L, 8319300.00);
    
    @Test
    public void getAllRecords_success() throws Exception {
        List<EmployeeRes> responseEmployee = new ArrayList<>(Arrays.asList(Record_1_res));
        
        ResponseSchema<List<EmployeeRes>> datas = new ResponseSchema<List<EmployeeRes>>();
        datas.setData(responseEmployee);
        
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        Mockito.when(responseService.apiSuccess(responseEmployee)).thenReturn(datas);
        
        ResponseEntity<?> responseEntity = new ResponseEntity<>(
        	responseService.apiSuccess(responseEmployee),
            header, 
            HttpStatus.OK
        );
        
        Mockito.<ResponseEntity<?>>when(employeeService.getAllDataEmployee()).thenReturn(responseEntity);
        
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].name", is("Jonah")));
    }
    

}
