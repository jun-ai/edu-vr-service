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
    @GetMapping("ageRateList")
    @ApiOperation(value = "各行业人才年龄阶段占比",notes = "各行业人才年龄阶段占比")
    public AjaxResult ageRateList(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.ageRateList()));
    }

    @GetMapping("yearTotalList")
    @ApiOperation(value = "人才年度总数",notes = "人才年度总数")
    public AjaxResult yearTotalList(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.yearTotalList()));
    }

    @GetMapping("reqSupplyRate")
    @ApiOperation(value = "行业人才需求与供应占比",notes = "行业人才需求与供应占比")
    public AjaxResult reqSupplyRate(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.reqSupplyRate()));
    }

    @GetMapping("employNumAndTrend")
    @ApiOperation(value = "就业人数及就业趋势",notes = "就业人数及就业趋势")
    public AjaxResult employNumAndTrend(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.employNumAndTrend()));
    }

    @GetMapping("inflow")
    @ApiOperation(value = "人才流入",notes = "人才流入")
    public AjaxResult inflow(){
        return AjaxResult.success(DataResult.success(bgPersonnelService.inflow()));
    }

}
