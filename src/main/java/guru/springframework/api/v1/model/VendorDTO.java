package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class VendorDTO {
    private Long id;
    private String name;
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
