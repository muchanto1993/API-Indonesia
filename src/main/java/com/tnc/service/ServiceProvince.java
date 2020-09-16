package com.tnc.service;

import java.util.List;

import com.tnc.model.ModelCity;
import com.tnc.model.ModelPostalCode;
import com.tnc.model.ModelProvince;

public interface ServiceProvince {

    List<ModelProvince> findAll();

    List<ModelProvince> findSpecificProvinceByProvinceName(String province_name);

    List<ModelCity> findAllCity();

    List<ModelCity> findSpecificCityByProvinceName(String province_name);

    List<ModelPostalCode> findByPostalCode(String postal_code);
    
}
