package com.mab.format;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class RequestDataFormat {

    @ApiModelProperty(notes = "Specific Province Name", example = "jawa barat")
    private String province_name;
    
    @ApiModelProperty(notes = "Specific City", example = "bandung")
    private String city;

    @ApiModelProperty(notes = "Specific Sub District", example = "kiaracondong")
    private String sub_district;

    @ApiModelProperty(notes = "Specific Urban", example = "BABAKAN SARI")
    private String urban;
    
    @ApiModelProperty(notes = "Specific Postal Code", example = "40283")
    private String postal_code;

}
