package com.tnc.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "length_data", "data" })
public class ResponseMessageFormat<T> {

    private Integer length_data;
    private T data;

}
