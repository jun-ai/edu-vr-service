package com.zhejianglab.edu.dao;

import com.zhejianglab.edu.model.entity.PersonnelGpNum;
import com.zhejianglab.edu.model.entity.PersonnelGpReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelGpReqMapper {

    List<PersonnelGpReq> selectList();
}
