package com.neosoft.springboot.test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springboot.bean.CarBean;
import com.neosoft.springboot.controller.AdminController;
import com.neosoft.springboot.repo.CarRepository;
import com.neosoft.springboot.service.CarService;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(AdminController.class)
class AdminControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	private CarBean carBean;
	
	@MockBean
	private CarService carService;
	
	@MockBean
	private CarRepository carRepo;
	

	
	Principal P_ADMIN = new Principal() {
        @Override
        public String getName() {
            return "ROLE_ADMIN";
        }
    };
	
	private CarBean RECORD1 = new CarBean(91L, "Nissan1", "Micra1", 2017, 20010, "no");
	private CarBean RECORD2 = new CarBean(92L, "Nissan2", "Micra2", 2019, 10000, "no");
	
	@Test
	public void shouldReturnListOfCars() throws Exception {
		List<CarBean> list = new ArrayList<CarBean>();
		list.add(RECORD1);
		list.add(RECORD2);
		Mockito.when(carService.getAllCars()).thenReturn(list);
	
		this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/viewCars").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().is(302))
			.andExpect(jsonPath("$", hasSize(2)));
	}
	
	
	
	


}
