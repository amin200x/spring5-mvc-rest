package guru.springframework.services;


import guru.springframework.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerByLastName(String lastName);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO update(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
