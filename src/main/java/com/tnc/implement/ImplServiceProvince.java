package com.tnc.implement;

import java.util.ArrayList;
import java.util.List;

import com.tnc.entitty.EntityPostalCode;
import com.tnc.entitty.EntityProvince;
import com.tnc.model.ModelCity;
import com.tnc.model.ModelProvince;
import com.tnc.model.ModelPostalCode;
import com.tnc.repository.RepositoryPostalCode;
import com.tnc.repository.RepositoryProvince;
import com.tnc.service.ServiceProvince;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplServiceProvince implements ServiceProvince {

    @Autowired
    private RepositoryProvince repositoryProvince;

    @Autowired
    private RepositoryPostalCode repositoryPostalCode;

    @Override
    public List<ModelProvince> findAll() {
        List<ModelProvince> listProvince = new ArrayList<>();
        for (EntityProvince entityProvince : repositoryProvince.findAll()) {
            ModelProvince modelProvince = new ModelProvince();
            modelProvince.setProvince_name(entityProvince.getProvince_name());
            modelProvince.setProvince_name_en(entityProvince.getProvince_name_en());

            listProvince.add(modelProvince);
        }

        return listProvince;
    }

    @Override
    public List<ModelProvince> findSpecificProvinceByProvinceName(String province_name) {
        List<ModelProvince> listSpecificProvince = new ArrayList<>();
        for (EntityProvince entityProvince : repositoryProvince.findByProvinceName(province_name)) {
            ModelProvince modelProvince = new ModelProvince();
            modelProvince.setProvince_name(entityProvince.getProvince_name());
            modelProvince.setProvince_name_en(entityProvince.getProvince_name_en());

            listSpecificProvince.add(modelProvince);
        }

        return listSpecificProvince;
    }

    @Override
    public List<ModelCity> findAllCity() {
        List<String> tempListCity = repositoryPostalCode.findAllCity();
        List<ModelCity> listCity = new ArrayList<>();
        for (int i = 0; i < tempListCity.size(); i++) {
            ModelCity modelCity = new ModelCity();
            modelCity.setCity(tempListCity.get(i));

            listCity.add(modelCity);
        }

        return listCity;
    }

    @Override
    public List<ModelCity> findSpecificCityByProvinceName(String province_name) {
        List<String> tempListCity = repositoryPostalCode.findCityByProvinceName(province_name);
        List<ModelCity> listCity = new ArrayList<>();
        for (int i = 0; i < tempListCity.size(); i++) {
            ModelCity modelCity = new ModelCity();
            modelCity.setCity(tempListCity.get(i));

            listCity.add(modelCity);
        }
        return listCity;
    }

    @Override
    public List<ModelPostalCode> findByPostalCode(String postal_code) {
        List<ModelPostalCode> listDetailProvinceByPostalCode = new ArrayList<>();
        for (EntityPostalCode entityPostalCode : repositoryPostalCode.findProvinceDetailByPostalCode(postal_code)) {
            ModelPostalCode modelProvincePostalCode = new ModelPostalCode();
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
