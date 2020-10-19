package com.tnc.repository;

import java.util.List;

import com.tnc.entitty.EntityPostalCode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryPostalCode extends JpaRepository<EntityPostalCode, Integer> {

    /* City - Begin */
    @Query(value = "select distinct(city) from t_postal_code order by city asc", nativeQuery = true)
    public List<String> findAllCity();

    @Query(value = "select distinct(city) from t_postal_code tpc join t_province tp on tp.province_code = tpc.province_code where upper(tp.province_name) = upper(:province_name) order by city asc", nativeQuery = true)
    public List<String> findCityByProvinceName(@Param("province_name") String province_name);
    /* City - End */

    /* Sub District - Begin */
    @Query(value = "select distinct(sub_district) from t_postal_code order by sub_district asc", nativeQuery = true)
    public List<String> findAllSubDistrict();

    @Query(value = "select distinct(sub_district) from t_postal_code where upper(city) = upper(:city) order by sub_district asc", nativeQuery = true)
    public List<String> findSubDistrictByCity(@Param("city") String city);
    /* Sub District - End */

    /* Urban - Begin */
    @Query(value = "select distinct(urban) from t_postal_code order by urban asc", nativeQuery = true)
    public List<String> findAllUrban();

    @Query(value = "select distinct(urban) from t_postal_code where upper(sub_district) = upper(:sub_district) order by urban asc", nativeQuery = true)
    public List<String> findUrbanBySubDistrict(@Param("sub_district") String sub_district);
    /* Urban - End */

    /* Postal Code - Begin */
    @Query(value = "select epc from EntityPostalCode epc where epc.postal_code = :postal_code")
    public List<EntityPostalCode> findProvinceDetailByPostalCode(@Param("postal_code") String postal_code);
    /* Postal Code - End */
}
