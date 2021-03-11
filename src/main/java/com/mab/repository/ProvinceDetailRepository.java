package com.mab.repository;

import java.util.List;

import com.mab.entitty.ProvinceDetailEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinceDetailRepository extends JpaRepository<ProvinceDetailEntity, Integer> {

    /* City - Begin */
    @Query(value = "select distinct(city) from t_province_detail order by city asc", nativeQuery = true)
    public List<String> findAllCity();

    @Query(value = "select distinct(city) from t_province_detail tpc join t_province tp on tp.province_code = tpc.province_code where upper(tp.province_name) = upper(:province_name) order by city asc", nativeQuery = true)
    public List<String> findCityByProvinceName(@Param("province_name") String province_name);
    /* City - End */

    /* Sub District - Begin */
    @Query(value = "select distinct(sub_district) from t_province_detail order by sub_district asc", nativeQuery = true)
    public List<String> findAllSubDistrict();

    @Query(value = "select distinct(sub_district) from t_province_detail where upper(city) = upper(:city) order by sub_district asc", nativeQuery = true)
    public List<String> findSubDistrictByCity(@Param("city") String city);
    /* Sub District - End */

    /* Urban - Begin */
    @Query(value = "select distinct(urban) from t_province_detail order by urban asc", nativeQuery = true)
    public List<String> findAllUrban();

    @Query(value = "select distinct(urban) from t_province_detail where upper(sub_district) = upper(:sub_district) order by urban asc", nativeQuery = true)
    public List<String> findUrbanBySubDistrict(@Param("sub_district") String sub_district);
    /* Urban - End */

    /* Postal Code - Begin */
    @Query(value = "select epc from ProvinceDetailEntity epc where epc.postal_code = :postal_code")
    public List<ProvinceDetailEntity> findProvinceDetailByPostalCode(@Param("postal_code") String postal_code);
    /* Postal Code - End */
}
