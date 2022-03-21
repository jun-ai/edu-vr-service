package com.zhejianglab.edu.service;

import com.zhejianglab.edu.model.entity.*;

import java.util.List;

public interface BgPersonnelService {

    public List<PersonnelGpNum> perSonnelGpNumList();

    public List<PersonnelGpReq> perSonnelGpReqList();

    public List<PersonnelAgeRate> ageRateList();

    public List<PersonnelYearTotal> yearTotalList();

    public List<PersonnelReqSupplyRate> reqSupplyRate();

    public List<PersonnelEmployNumAndTrend> employNumAndTrend();

    public List<PersonnelInflow> inflow();
}
