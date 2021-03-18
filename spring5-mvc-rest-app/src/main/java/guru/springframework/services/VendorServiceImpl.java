package guru.springframework.services;

import guru.springframework.api.v1.mapper.CategoryMapper;
import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.controller.VendorController;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream().map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(VendorController.VENDORS_URL + "/" + vendor.getId());
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorByName(String name) {
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendorRepository.getByName(name));
        vendorDTO.setVendorUrl(VendorController.VENDORS_URL + "/" + vendorDTO.getId());
        return vendorDTO;
    }

    @Override
    public VendorDTO save(VendorDTO vendorDTO) {
        return vendorMapper.vendorToVendorDTO(
                vendorRepository.save(
                        vendorMapper.vendorDTOToVendor(vendorDTO)));
    }

    @Override
    public VendorDTO update(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            vendor.setName(vendorDTO.getName());
            return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
        }).orElseThrow(ResourceNotFoundException::new);

    }

    @Override
    public VendorDTO patch(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            if (vendorDTO.getName() != null)
                vendor.setName(vendorDTO.getName());
            return vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        vendorRepository.deleteById(id);
    }
}
