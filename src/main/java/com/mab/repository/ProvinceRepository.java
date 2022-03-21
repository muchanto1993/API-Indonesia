package com.mab.repository;

import java.util.List;

import com.mab.entity.ProvinceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {

    @Query("select p from ProvinceEntity p where upper(p.province_name) like upper(concat('%', :province_name, '%')) or upper(p.province_name_en) like upper(concat('%', :province_name, '%'))")
    public List<ProvinceEntity> findByProvinceName(@Param("province_name") String province_name);

}
