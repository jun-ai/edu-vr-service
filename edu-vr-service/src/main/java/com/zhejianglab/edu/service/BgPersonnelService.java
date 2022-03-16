package com.zhejianglab.edu.service;

import com.zhejianglab.edu.model.entity.PersonnelAgeRate;
import com.zhejianglab.edu.model.entity.PersonnelGpNum;
import com.zhejianglab.edu.model.entity.PersonnelGpReq;
import com.zhejianglab.edu.model.entity.PersonnelYearTotal;
import java.util.List;

public interface BgPersonnelService {

    public List<PersonnelGpNum> perSonnelGpNumList();

    public List<PersonnelGpReq> perSonnelGpReqList();

    public List<PersonnelAgeRate> gpAgeRateList();

    public List<PersonnelYearTotal> gpYearTotalList();
}
