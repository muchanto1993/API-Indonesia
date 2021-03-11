package com.mab.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class RequestDataFormat {

    private String province_name;
    private String city;
    private String sub_district;
    private String urban;
    private String postal_code;

}
