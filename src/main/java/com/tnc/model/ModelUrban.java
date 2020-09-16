package com.tnc.model;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ModelUrban extends ModelSubDistrict{
    
    private String urban;

}
