package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.OptionalStock;
import com.tencent.wxcloudrun.service.OptionStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OptionalStockController {

    final Logger logger;
    private OptionStockService optionStockService;

    public OptionalStockController(@Autowired OptionStockService optionStockService) {
        this.logger = LoggerFactory.getLogger(CounterController.class);
        this.optionStockService = optionStockService;
    }

    /**
     * 获取用户所有自选股
     * @return API response json
     */
    @GetMapping(value = "/optionalStockList")
    ApiResponse optionalStockList(@RequestParam("uid") String uid) {
        this.logger.info("获取用户{" + uid + "}的相关自选股票");
        return ApiResponse.ok(optionStockService.queryOptionalStock(uid));
    }

    /**
     * 新增用户策略模型
     * @return API response json
     */
    @PostMapping(value = "/upStrategyInfo")
    ApiResponse upStrategyInfo(@RequestBody OptionalStock optionalStock) {
        this.logger.info("添加或更新用户{" + optionalStock.getUid() + "}的相关自选股票", optionalStock);
        try {
            optionStockService.updateOptionalStock(optionalStock);
            return ApiResponse.ok();
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }
}
