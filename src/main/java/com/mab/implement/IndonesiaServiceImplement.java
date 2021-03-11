package com.mab.implement;

import java.util.ArrayList;
import java.util.List;

import com.mab.entitty.ProvinceDetailEntity;
import com.mab.entitty.ProvinceEntity;
import com.mab.model.CityModel;
import com.mab.model.PostalCodeModel;
import com.mab.model.ProvinceModel;
import com.mab.model.SubDistrictModel;
import com.mab.model.UrbanModel;
import com.mab.repository.ProvinceDetailRepository;
import com.mab.repository.ProvinceRepository;
import com.mab.service.IndonesiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndonesiaServiceImplement implements IndonesiaService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private ProvinceDetailRepository provinceDetailRepository;

    @Override
    public List<ProvinceModel> findAllProvince() {
        List<ProvinceModel> listProvince = new ArrayList<>();
        for (ProvinceEntity entityProvince : provinceRepository.findAll()) {
            ProvinceModel modelProvince = new ProvinceModel();
            modelProvince.setProvince_name(entityProvince.getProvince_name());
            modelProvince.setProvince_name_en(entityProvince.getProvince_name_en());

            listProvince.add(modelProvince);
        }

        return listProvince;
    }

    @Override
    public List<ProvinceModel> findSpecificProvinceByProvinceName(String province_name) {
        List<ProvinceModel> listSpecificProvince = new ArrayList<>();
        for (ProvinceEntity entityProvince : provinceRepository.findByProvinceName(province_name)) {
            ProvinceModel modelProvince = new ProvinceModel();
            modelProvince.setProvince_name(entityProvince.getProvince_name());
            modelProvince.setProvince_name_en(entityProvince.getProvince_name_en());

            listSpecificProvince.add(modelProvince);
        }

        return listSpecificProvince;
    }

    @Override
    public List<CityModel> findAllCity() {
        List<String> tempListCity = provinceDetailRepository.findAllCity();
        List<CityModel> listCity = new ArrayList<>();
        for (int i = 0; i < tempListCity.size(); i++) {
            CityModel modelCity = new CityModel();
            modelCity.setCity(tempListCity.get(i));

            listCity.add(modelCity);
        }

        return listCity;
    }

    @Override
    public List<CityModel> findSpecificCityByProvinceName(String province_name) {
        List<String> tempListCity = provinceDetailRepository.findCityByProvinceName(province_name);
        List<CityModel> listCity = new ArrayList<>();
        for (int i = 0; i < tempListCity.size(); i++) {
            CityModel modelCity = new CityModel();
            modelCity.setCity(tempListCity.get(i));

            listCity.add(modelCity);
        }
        return listCity;
    }

    @Override
    public List<SubDistrictModel> findAllSubDistrict() {
        List<String> tempListSubDistrict = provinceDetailRepository.findAllSubDistrict();
        List<SubDistrictModel> listSubDistrict = new ArrayList<>();
        for (int i = 0; i < tempListSubDistrict.size(); i++) {
            SubDistrictModel modelSubDistrict = new SubDistrictModel();
            modelSubDistrict.setSub_district(tempListSubDistrict.get(i));

            listSubDistrict.add(modelSubDistrict);
        }

        return listSubDistrict;
    }

    @Override
    public List<SubDistrictModel> findSpecificSubDistrictByCity(String city) {
        List<String> tempListSubDistrict = provinceDetailRepository.findSubDistrictByCity(city);
        List<SubDistrictModel> listSubDistrict = new ArrayList<>();
        for (int i = 0; i < tempListSubDistrict.size(); i++) {
            SubDistrictModel modelSubDistrict = new SubDistrictModel();
            modelSubDistrict.setSub_district(tempListSubDistrict.get(i));

            listSubDistrict.add(modelSubDistrict);
        }

        return listSubDistrict;
    }

    @Override
    public List<UrbanModel> findAllUrban() {
        List<String> tempListUrban = provinceDetailRepository.findAllUrban();
        List<UrbanModel> listUrban = new ArrayList<>();
        for (int i = 0; i < tempListUrban.size(); i++) {
            UrbanModel modelUrban = new UrbanModel();
            modelUrban.setUrban(tempListUrban.get(i));

            listUrban.add(modelUrban);
        }

        return listUrban;
    }

    @Override
    public List<UrbanModel> findSpecificUrbanBySubDistrict(String sub_district) {
        List<String> tempListUrban = provinceDetailRepository.findUrbanBySubDistrict(sub_district);
        List<UrbanModel> listUrban = new ArrayList<>();
        for (int i = 0; i < tempListUrban.size(); i++) {
            UrbanModel modelUrban = new UrbanModel();
            modelUrban.setUrban(tempListUrban.get(i));

            listUrban.add(modelUrban);
        }

        return listUrban;
    }

    @Override
    public List<PostalCodeModel> findByPostalCode(String postal_code) {
        List<PostalCodeModel> listDetailProvinceByPostalCode = new ArrayList<>();
        for (ProvinceDetailEntity entityPostalCode : provinceDetailRepository.findProvinceDetailByPostalCode(postal_code)) {
            PostalCodeModel modelProvincePostalCode = new PostalCodeModel();
            modelProvincePostalCode.setProvince_name(entityPostalCode.getProvince().getProvince_name());
            modelProvincePostalCode.setProvince_name_en(entityPostalCode.getProvince().getProvince_name_en());
            modelProvincePostalCode.setCity(entityPostalCode.getCity());
            modelProvincePostalCode.setSub_district(entityPostalCode.getSub_district());
            modelProvincePostalCode.setUrban(entityPostalCode.getUrban());
            modelProvincePostalCode.setPostal_code(entityPostalCode.getPostal_code());

            listDetailProvinceByPostalCode.add(modelProvincePostalCode);
        }

        return listDetailProvinceByPostalCode;
    }

}
