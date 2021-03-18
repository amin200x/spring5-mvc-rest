package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.model.CustomerDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper;

    public CustomerMapper(@Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if (customer != null)
            return modelMapper.map(customer, CustomerDTO.class);
        else return new CustomerDTO();
    }

    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if (customerDTO != null)
            return modelMapper.map(customerDTO, Customer.class);
        else return new Customer();
    }
}
