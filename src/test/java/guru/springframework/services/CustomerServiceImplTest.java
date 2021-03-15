package guru.springframework.services;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CustomerServiceImplTest {
    public static final String LAST_NAME = "Ghadimian";
    public static final String FIRST_NAME = "Amin";
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;


    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //categoryService = new CategoryServiceImpl(new CategoryMapper(new ModelMapper()), categoryRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void getAllCategories() throws Exception {
        List<CustomerDTO> categories = Arrays.asList(new CustomerDTO(), new CustomerDTO(), new CustomerDTO(), new CustomerDTO());
        when(customerService.getAllCustomers()).thenReturn(categories);


        mockMvc.perform(get("/api/v1/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(4)));

    }

    @Test
    void getCategoryByName() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName(LAST_NAME);
        customerDTO.setFirstName(FIRST_NAME);

        when(customerService.getCustomerByLastName(anyString())).thenReturn(customerDTO);

        mockMvc.perform(get("/api/v1/customers/"+LAST_NAME).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName", equalTo(LAST_NAME)));
    }
}