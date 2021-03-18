package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class VendorDTO {
    private Long id;
    @ApiModelProperty(value = "This is the name of vendor", required = true)
    private String name;
    @ApiModelProperty(value = "this is vendor url.")
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
