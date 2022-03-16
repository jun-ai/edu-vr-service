package com.zhejianglab.edu.dao;

import com.zhejianglab.edu.model.entity.PersonnelAgeRate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelAgeRateMapper {

    List<PersonnelAgeRate> selectList();
}
