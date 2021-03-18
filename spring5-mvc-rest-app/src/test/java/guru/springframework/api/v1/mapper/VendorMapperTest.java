package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Vendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class VendorMapperTest {
    @Autowired
    VendorMapper vendorMapper;

    @Test
    void categoryToCategoryDto() {
        Vendor vendor = new Vendor();
        vendor.setName("Vendor1");
        vendor.setId(1001L);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
        assertEquals("Vendor1", vendorDTO.getName());

    }


    @Test
    void categoryDTOToCategory() {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName("Vendor1");
        vendorDTO.setId(1001L);

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        assertEquals(1001L, vendor.getId());
    }
}