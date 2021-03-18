package guru.springframework.services;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAllVendors();
    VendorDTO getVendorByName(String name);

    VendorDTO save(VendorDTO vendorDTO);
    VendorDTO update(Long id, VendorDTO vendorDTO);
    VendorDTO patch(Long id, VendorDTO vendorDTO);
    void deleteById(Long id);

}
