package com.zhejianglab.edu.dao;

import com.zhejianglab.edu.model.entity.PersonnelInflow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonnelInflowMapper {

    List<PersonnelInflow> selectList();
}
