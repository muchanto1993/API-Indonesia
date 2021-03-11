package com.mab.util;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "timestamp", "status", "error", "message", "path" })
@JsonInclude(Include.NON_NULL)
public class ResponseFormat {

    private Date timestamp;
    private Integer status;
    private String error;
    private ResponseMessageFormat message;
    private String path;

}
