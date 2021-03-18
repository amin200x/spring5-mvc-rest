package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.model.CustomerDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerMapperTest {
    public static final String FIRST_NAME = "Sam";
    public static final String LAST_NAME = "Smith";
    @Autowired
    CustomerMapper customerMapper;

    @Test
    void categoryToCategoryDto() {
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
        assertEquals(LAST_NAME, customerDTO.getLastName());

    }


    @Test
    void categoryDTOToCategory() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setLastName(LAST_NAME);

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        assertEquals(FIRST_NAME, customer.getFirstName());
    }
}