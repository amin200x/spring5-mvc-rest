package guru.springframework.controller;

import guru.springframework.api.v1.model.CategoryDTO;
import guru.springframework.api.v1.model.CategoryListDTO;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.services.CategoryService;
import guru.springframework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping(VendorController.VENDORS_URL)

public class VendorController {
    public static final String VENDORS_URL = "/api/v1/vendors";
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getCategories() {
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO addNew(@RequestBody VendorDTO vendorDTO) {
        return vendorService.save(vendorDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO update(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.update(id, vendorDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patch(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.patch(id, vendorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void patch(@PathVariable Long id) {
         vendorService.deleteById(id);
    }
}
