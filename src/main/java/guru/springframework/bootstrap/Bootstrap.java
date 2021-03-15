package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        categories();
        customers();
        vendors();

    }

    private void customers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Ali");
        customer1.setLastName("Hani");

        Customer customer2 = new Customer();
        customer2.setFirstName("Samad");
        customer2.setLastName("Alavi");

        Customer customer3 = new Customer();
        customer3.setFirstName("Kazem");
        customer3.setLastName("Dara");

        Customer customer4 = new Customer();
        customer4.setFirstName("Yashar");
        customer4.setLastName("Yalniz");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        System.out.println("Customers loaded: " + customerRepository.count());
    }

    private void categories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category nuts = new Category();
        nuts.setName("Nuts");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        categoryRepository.save(fruits);
        categoryRepository.save(nuts);
        categoryRepository.save(dried);
        categoryRepository.save(exotic);
        categoryRepository.save(fresh);

        System.out.println("Categories loaded: " + categoryRepository.count());
    }

    private void vendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("Vendor1");

        Vendor vendor2 = new Vendor();
        vendor2.setName("Vendor2");

        Vendor vendor3 = new Vendor();
        vendor3.setName("Vendor3");

        Vendor vendor4 = new Vendor();
        vendor4.setName("Vendor4");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
        vendorRepository.save(vendor4);

        System.out.println("Vendors loaded: " + vendorRepository.count());
    }
}
