package com.mab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_province_detail")
@Getter
@Setter
public class ProvinceDetailEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "province_code", nullable = false)
    private ProvinceEntity province;

    @Column(name = "city")
    private String city;

    @Column(name = "sub_district")
    private String sub_district;

    @Column(name = "urban")
    private String urban;

    @Column(name = "postal_code")
    private String postal_code;

}
