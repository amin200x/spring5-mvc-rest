package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Category;
import guru.springframework.domain.Vendor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendorMapper {
    private final ModelMapper modelMapper;

    public VendorMapper(@Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VendorDTO vendorToVendorDTO(Vendor vendor) {
        if (vendor != null)
            return modelMapper.map(vendor, VendorDTO.class);
        else return new VendorDTO();
    }

    public Vendor vendorDTOToVendor(VendorDTO vendorDTO) {
        if (vendorDTO != null)
            return modelMapper.map(vendorDTO, Vendor.class);
        else return new Vendor();
    }
}
