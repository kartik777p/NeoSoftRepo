package com.neosoft.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springboot.bean.CarBean;
import com.neosoft.springboot.bean.RentCarBean;
import com.neosoft.springboot.controller.CustomerController;
import com.neosoft.springboot.repo.CarRepository;
import com.neosoft.springboot.repo.CustomerRepository;
import com.neosoft.springboot.repo.RentCarRepository;
import com.neosoft.springboot.service.CarService;
import com.neosoft.springboot.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	 @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
		  
		
		@MockBean
		private CarService carService;
		
		@MockBean
		private CarRepository carRepo;
		
		@MockBean
		private CustomerService customerService;
		
		@MockBean
		private CustomerRepository customerRepo;
		
		@MockBean
		private RentCarRepository rentCarRepo;
		
		
		@Test
		public void redirectToCustomerDashboard_success() {
			
			try {
				mockMvc.perform(get("/customer")).andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().contentType("text/html;charset=UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Test
		public void getRentedCarList_success() throws Exception {
			List<CarBean> list = new ArrayList<CarBean>();
			Mockito.when(carRepo.findByRented("no")).thenReturn(list);
			
			mockMvc.perform(MockMvcRequestBuilders
	                .get("/customer/viewRentedCars")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());  
		}

}
