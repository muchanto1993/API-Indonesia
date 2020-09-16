package com.tnc.repository;

import java.util.List;

import com.tnc.entitty.EntityPostalCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryPostalCode extends JpaRepository<EntityPostalCode, Integer> {

    @Query(value = "select epc from EntityPostalCode epc where epc.postal_code = :postal_code")
    public List<EntityPostalCode> findProvinceDetailByPostalCode(@Param("postal_code") String postal_code);

    @Query(value = "select distinct(city) from t_postal_code order by city asc", nativeQuery = true)
    public List<String> findAllCity();

    @Query(value = "select distinct(city) from t_postal_code tpc join t_province tp on tp.province_code = tpc.province_code where upper(tp.province_name) = upper(:province_name) order by city asc", nativeQuery = true)
    public List<String> findCityByProvinceName(@Param("province_name") String province_name);

}
