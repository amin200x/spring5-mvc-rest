package guru.springframework.services;

import guru.springframework.api.v1.mapper.CategoryMapper;
import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.model.CustomerDTO;
import guru.springframework.controller.CustomerController;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream().map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl(CustomerController.CUSTOMER_URL+"/"  + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByLastName(String lastName) {
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customerRepository.findByLastName(lastName));
        customerDTO.setCustomerUrl(CustomerController.CUSTOMER_URL+"/"  + customerDTO.getId());
        return customerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id).map(customer -> {
            CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
            customerDTO.setCustomerUrl(CustomerController.CUSTOMER_URL+"/" + customerDTO.getId());
            return customerDTO;

        }).orElseThrow(ResourceNotFoundException::new);


    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer saveCustomer = customerRepository.save(customer);

        CustomerDTO returnedCustomerDTO = customerMapper.customerToCustomerDTO(saveCustomer);
        returnedCustomerDTO.setCustomerUrl(CustomerController.CUSTOMER_URL+"/" + saveCustomer.getId());
        return returnedCustomerDTO;
    }

    @Override
    public CustomerDTO update(Long id, CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            Customer saveCustomer = customerRepository.save(customer);

            CustomerDTO returnedDTO = customerMapper.customerToCustomerDTO(saveCustomer);
            returnedDTO.setCustomerUrl(CustomerController.CUSTOMER_URL+"/"  + saveCustomer.getId());
            return returnedDTO;
        } else {
            return customerDTO;
        }

    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstName() != null)
                customer.setFirstName(customerDTO.getFirstName());
            if (customerDTO.getLastName() != null)
                customer.setLastName(customerDTO.getLastName());

            CustomerDTO returnedDTO = customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            returnedDTO.setCustomerUrl(CustomerController.CUSTOMER_URL+"/"  + customer.getId());
            return returnedDTO;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

}
