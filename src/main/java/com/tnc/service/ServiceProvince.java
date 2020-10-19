package com.tnc.service;

import java.util.List;

import com.tnc.model.ModelCity;
import com.tnc.model.ModelPostalCode;
import com.tnc.model.ModelProvince;
import com.tnc.model.ModelSubDistrict;
import com.tnc.model.ModelUrban;

public interface ServiceProvince {

    List<ModelProvince> findAll();

    List<ModelProvince> findSpecificProvinceByProvinceName(String province_name);

    List<ModelCity> findAllCity();

    List<ModelCity> findSpecificCityByProvinceName(String province_name);

    List<ModelSubDistrict> findAllSubDistrict();

    List<ModelSubDistrict> findSpecificSubDistrictByCity(String city);

    List<ModelUrban> findAllUrban();

    List<ModelUrban> findSpecificUrbanBySubDistrict(String sub_district);

    List<ModelPostalCode> findByPostalCode(String postal_code);

}
