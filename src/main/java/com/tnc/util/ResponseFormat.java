package com.tnc.util;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "timestamp", "status", "error", "message", "path" })
public class ResponseFormat {

    private Date timestamp;
    private Integer status;
    private String error;
    private ResponseMessageFormat message;
    private String path;

}
