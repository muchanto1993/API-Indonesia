package com.mab.service;

import java.util.List;

import com.mab.model.CityModel;
import com.mab.model.PostalCodeModel;
import com.mab.model.ProvinceModel;
import com.mab.model.SubDistrictModel;
import com.mab.model.UrbanModel;

public interface IndonesiaService {

    List<ProvinceModel> findAllProvince();

    List<ProvinceModel> findSpecificProvinceByProvinceName(String province_name);

    List<CityModel> findAllCity();

    List<CityModel> findSpecificCityByProvinceName(String province_name);

    List<SubDistrictModel> findAllSubDistrict();

    List<SubDistrictModel> findSpecificSubDistrictByCity(String city);

    List<UrbanModel> findAllUrban();

    List<UrbanModel> findSpecificUrbanBySubDistrict(String sub_district);

    List<PostalCodeModel> findByPostalCode(String postal_code);

}
