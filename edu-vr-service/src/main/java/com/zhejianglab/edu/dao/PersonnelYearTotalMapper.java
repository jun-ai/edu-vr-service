package com.zhejianglab.edu.dao;

import com.zhejianglab.edu.model.entity.PersonnelGpReq;
import com.zhejianglab.edu.model.entity.PersonnelYearTotal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelYearTotalMapper {

    List<PersonnelYearTotal> selectList();
}
