package com.neosoft.springboot;

import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.springboot.bean.CarBean;
import com.neosoft.springboot.bean.CustomerBean;
import com.neosoft.springboot.bean.RentCarBean;
import com.neosoft.springboot.bean.Role;
import com.neosoft.springboot.exception.InvalidRequestException;
import com.neosoft.springboot.repo.CarRepository;
import com.neosoft.springboot.repo.CustomerRepository;
import com.neosoft.springboot.repo.RentCarRepository;
import com.neosoft.springboot.service.CarService;
import com.neosoft.springboot.service.CustomerService;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
class CarRentalUsingSpringApplicationTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	private ObjectMapper mapper;

	
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

	private CarBean RECORD1 = new CarBean(91L, "Nissan1", "Micra1", 2017, 20010, "no");
	private CarBean RECORD2 = new CarBean(92L, "Nissan2", "Micra2", 2019, 10000, "no");
	
	private CustomerBean CUSTOMER1 = new CustomerBean(9L, "alex", "adams1", "asd@mail.com", 1231231231L, new ArrayList<Role>());
	private CustomerBean CUSTOMER2= new CustomerBean(10L, "alex2", "adams2", "asds@mail.com", 100001233L, new ArrayList<Role>());
	
	@BeforeAll
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	Principal P_ADMIN = new Principal() {
        @Override
        public String getName() {
            return "ROLE_ADMIN";
        }
    };
	
	Principal P_CUSTOMER = new Principal() {
        @Override
        public String getName() {
            return "ROLE_CUSTOMER";
        }
    };
	
	
	@Test
	public void testGetPageLogin() {
		try {
			mockMvc.perform(get("/login")).andExpect(status().isOk())
			.andDo(print())
			.andExpect(content().contentType("text/html;charset=UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPageRegister() {
		try {
			mockMvc.perform(get("/custregistration")).andExpect(status().isOk())
			.andDo(print())
			.andExpect(content().contentType("text/html;charset=UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetLogin() {
		try {
			mockMvc.perform(get("/admin/dashboard").principal(P_ADMIN))
			.andExpect(status().is2xxSuccessful())
			.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Test
	public void testPostLogin() {
		try {
			mockMvc.perform(post("/login")
			.param("username", "john").param("password", "s3cr3t")).andDo(print()).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void shouldReturnListOfCars() throws Exception {
//		List<CarBean> list = new ArrayList<CarBean>();
//		list.add(RECORD1);
//		list.add(RECORD2);
//		Mockito.when(carRepo.findAll()).thenReturn(list);
//	
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/admin/viewCars").contentType(MediaType.APPLICATION_JSON))
//			.andExpect(MockMvcResultMatchers.status().is(302))
//			.andExpect(view().name("view_cars"))
//			.andExpect(model().attributeExists("listCars"))
//			.andExpect(model().attribute("listCars", list))
//			.andExpect(jsonPath("$", hasSize(2)));
//	}
	
	@Test
	public void addCarToDb_success() {
		CarBean car = new CarBean(90L, "Nissan", "Micra", 2018, 20000, "no");
		carService.saveCar(car);
		assertNotNull(carRepo.findById(90L));
	}
	

	@Test
	public void deleteCar_success() throws Exception {
		
    	Mockito.when(customerRepo.findById(CUSTOMER1.getId()))
        .thenReturn(Optional.of(CUSTOMER1));
    	
        mockMvc.perform(MockMvcRequestBuilders
                .get("/admin/deleteCustomerRecord/"+CUSTOMER1.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(302));   
	}
	
	
	@Test
	public void viewRentedCars_success() throws Exception {
		List<RentCarBean> list = new ArrayList<RentCarBean>();
		Mockito.when(rentCarRepo.findByReturnstatusOrderByRenteddateDesc("no")).thenReturn(list);
		
		mockMvc.perform(MockMvcRequestBuilders
                .get("/admin/viewRentedCars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());  
	}
	
	@Test
	public void viewCustomers_success() throws Exception {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		Mockito.when(customerService.getAllCustomers()).thenReturn(list);
		
		mockMvc.perform(MockMvcRequestBuilders
                .get("/admin/viewCustomers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());  
	}
	
//	@Test
//	public void viewUpdateForm_success() throws Exception {
//		CustomerBean customer = CustomerBean.builder()
//				.id(20L)
//				.name("yash")
//				.password("yash1234")
//				.email("abc@mail.com")
//				.mobile(1231231231L)
//				.roles(new ArrayList<Role>())
//				.build();
//		
//		 Mockito.when(customerRepo.findById(CUSTOMER2.getId()))
//	        .thenReturn(Optional.of(CUSTOMER2));
//	        
//        Mockito.when(customerRepo.save(customer)).thenReturn(customer);
//	        
//		
//		
//		mockMvc.perform(MockMvcRequestBuilders
//                .get("/admin/showFormForUpdate/"+CUSTOMER2.getId())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(view().name("update_customer"))
//                .andExpect(model().attributeExists("customer"))
//                .andExpect(jsonPath("$.name", is("alex2")));  
//	}
	

	

}
