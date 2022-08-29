package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.StrategyModel;

import java.util.List;

public interface StrategyService {
    List<StrategyModel> queryStrategyModelListByUid(String uid);

    void updateStrategyModeInfo(StrategyModel strategyModel) throws Exception;
}
