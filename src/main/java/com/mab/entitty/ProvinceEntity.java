package com.mab.entitty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_province")
@Getter
@Setter
public class ProvinceEntity {

    @Id
    @Column(name = "province_code")
    private Integer province_code;
    
    @Column(name = "province_name")
    private String province_name;
    
    @Column(name = "province_name_en")
    private String province_name_en;

}
