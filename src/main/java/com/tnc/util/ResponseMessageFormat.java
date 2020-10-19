package com.tnc.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "length_data", "data" })
@JsonInclude(Include.NON_NULL)
public class ResponseMessageFormat<T> {

    private Integer length_data;
    private T data;

}
