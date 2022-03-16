package com.zhejianglab.edu.impl;

import com.zhejianglab.edu.dao.PersonnelAgeRateMapper;
import com.zhejianglab.edu.dao.PersonnelGpNumMapper;
import com.zhejianglab.edu.dao.PersonnelGpReqMapper;
import com.zhejianglab.edu.dao.PersonnelYearTotalMapper;
import com.zhejianglab.edu.model.entity.PersonnelAgeRate;
import com.zhejianglab.edu.model.entity.PersonnelGpNum;
import com.zhejianglab.edu.model.entity.PersonnelGpReq;
import com.zhejianglab.edu.model.entity.PersonnelYearTotal;
import com.zhejianglab.edu.service.BgPersonnelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BgPersonnelServiceImpl implements BgPersonnelService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonnelGpNumMapper personnelGpNumMapper;

    @Autowired
    private PersonnelGpReqMapper personnelGpReqMapper;

    @Autowired
    private PersonnelAgeRateMapper personnelAgeRateMapper;

    @Autowired
    private PersonnelYearTotalMapper personnelYearTotalMapper;

    @Override
    public List<PersonnelGpNum> perSonnelGpNumList() {
        return personnelGpNumMapper.selectList();
    }

    @Override
    public List<PersonnelGpReq> perSonnelGpReqList() {
        return personnelGpReqMapper.selectList();
    }

    @Override
    public List<PersonnelAgeRate> gpAgeRateList() {
        return personnelAgeRateMapper.selectList();
    }

    @Override
    public List<PersonnelYearTotal> gpYearTotalList() {
        return personnelYearTotalMapper.selectList();
    }
}
