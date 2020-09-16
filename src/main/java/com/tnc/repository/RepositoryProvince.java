package com.tnc.repository;

import java.util.List;

import com.tnc.entitty.EntityProvince;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryProvince extends JpaRepository<EntityProvince, Integer> {

    @Query("select p from EntityProvince p where upper(p.province_name) like upper(concat('%', :province_name, '%')) or upper(p.province_name_en) like upper(concat('%', :province_name, '%'))")
    public List<EntityProvince> findByProvinceName(@Param("province_name") String province_name);

}
