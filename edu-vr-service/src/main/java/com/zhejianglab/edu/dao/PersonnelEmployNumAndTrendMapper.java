package com.zhejianglab.edu.dao;

import com.zhejianglab.edu.model.entity.PersonnelEmployNumAndTrend;
import com.zhejianglab.edu.model.entity.PersonnelGpNum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelEmployNumAndTrendMapper {
    List<PersonnelEmployNumAndTrend> selectList();
}
