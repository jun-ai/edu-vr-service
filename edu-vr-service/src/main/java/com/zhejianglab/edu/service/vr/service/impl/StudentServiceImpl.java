package com.zhejianglab.edu.service.vr.service.impl;

import com.zhejianglab.edu.model.vo.StudentReqVo;
import com.zhejianglab.edu.service.vr.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Boolean leftRoom(StudentReqVo studentReqVO) {
        return null;
    }

    @Override
    public Boolean verifyIsLive(StudentReqVo studentReqVo) {
        return null;
    }
}
