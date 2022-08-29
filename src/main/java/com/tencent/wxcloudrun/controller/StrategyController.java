package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.StrategyModel;
import com.tencent.wxcloudrun.service.StrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StrategyController {

    final Logger logger;
    private StrategyService strategyService;

    public StrategyController(@Autowired StrategyService strategyService) {
        this.logger = LoggerFactory.getLogger(CounterController.class);
        this.strategyService = strategyService;
    }

    /**
     * 获取用户所有策略模型
     * @return API response json
     */
    @GetMapping(value = "/strategyList")
    ApiResponse get(@RequestParam("uid") String uid) {
        this.logger.info("获取用户{" + uid + "}的相关策略模型");
        return ApiResponse.ok(strategyService.queryStrategyModelListByUid(uid));
    }

    /**
     * 新增用户策略模型
     * @return API response json
     */
    @PostMapping(value = "/upStrategyInfo")
    ApiResponse get(@RequestBody StrategyModel strategyModel) {
        this.logger.info("添加或更新用户{" + strategyModel.getUid() + "}的相关策略模型", strategyModel);
        try {
            strategyService.updateStrategyModeInfo(strategyModel);
            return ApiResponse.ok();
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}
