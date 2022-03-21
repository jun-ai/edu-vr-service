package com.zhejianglab.edu.dao;

import com.zhejianglab.edu.model.entity.PersonnelReqSupplyRate;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PersonnelReqSupplyRateMapper {
    List<PersonnelReqSupplyRate> selectList();
}
