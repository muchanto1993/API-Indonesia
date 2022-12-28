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
public class RequestBodyFormat {

    @ApiModelProperty(notes = "ALL Province", example = "101", required = true)
    private Integer function_code;
    private RequestDataFormat data;

}
