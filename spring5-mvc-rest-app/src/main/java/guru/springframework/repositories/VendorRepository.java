package guru.springframework.repositories;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor getByName(String name);
}
