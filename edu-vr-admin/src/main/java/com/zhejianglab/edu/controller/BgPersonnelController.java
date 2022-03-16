package com.zhejianglab.edu.controller;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.service.BgPersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bg/personnel")
@Api(tags = {"大屏人才端接口", "大屏人才端接口"})
public class BgPersonnelController {

    @Autowired
    private BgPersonnelService bgPersonnelService;

    @GetMapping("gpNumList")
    @ApiOperation(value = "人才缺口数量",notes = "人才缺口数量")
    public AjaxResult perSonnelGpNumList(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.perSonnelGpNumList()));
    }

    @GetMapping("gpReqList")
    @ApiOperation(value = "各领域人才需求",notes = "各领域人才需求")
    public AjaxResult perSonnelGpReqList(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.perSonnelGpReqList()));
    }
    @GetMapping("gpAgeRateList")
    @ApiOperation(value = "各行业人才年龄阶段占比",notes = "各行业人才年龄阶段占比")
    public AjaxResult gpAgeRateList(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.gpAgeRateList()));
    }

    @GetMapping("gpYearTotalList")
    @ApiOperation(value = "人才年度总数",notes = "人才年度总数")
    public AjaxResult gpYearTotalList(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.gpYearTotalList()));
    }


}
