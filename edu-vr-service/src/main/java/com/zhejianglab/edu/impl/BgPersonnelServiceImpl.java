package com.zhejianglab.edu.impl;

import com.zhejianglab.edu.dao.*;
import com.zhejianglab.edu.model.entity.*;
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

    @Autowired
    private PersonnelReqSupplyRateMapper personnelReqSupplyRateMapper;

    @Autowired
    private PersonnelEmployNumAndTrendMapper personnelEmployNumAndTrendMapper;

    @Autowired
    private PersonnelInflowMapper personnelInflowMapper;

    @Override
    public List<PersonnelGpNum> perSonnelGpNumList() {
        return personnelGpNumMapper.selectList();
    }

    @Override
    public List<PersonnelGpReq> perSonnelGpReqList() {
        return personnelGpReqMapper.selectList();
    }

    @Override
    public List<PersonnelAgeRate> ageRateList() {
        return personnelAgeRateMapper.selectList();
    }

    @Override
    public List<PersonnelYearTotal> yearTotalList() {
        return personnelYearTotalMapper.selectList();
    }

    @Override
    public List<PersonnelReqSupplyRate> reqSupplyRate() {
        return personnelReqSupplyRateMapper.selectList();
    }

    @Override
    public List<PersonnelEmployNumAndTrend> employNumAndTrend() {
        return personnelEmployNumAndTrendMapper.selectList();
    }

    @Override
    public List<PersonnelInflow> inflow() {
        return personnelInflowMapper.selectList();
    }
}
