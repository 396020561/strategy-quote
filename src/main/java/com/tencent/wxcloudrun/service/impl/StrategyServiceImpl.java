package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.StrategyModelMapper;
import com.tencent.wxcloudrun.model.StrategyModel;
import com.tencent.wxcloudrun.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {

    final StrategyModelMapper strategyModelMapper;

    public StrategyServiceImpl(@Autowired StrategyModelMapper strategyModelMapper) {
        this.strategyModelMapper = strategyModelMapper;
    }

    @Override
    public List<StrategyModel> queryStrategyModelListByUid(String uid) {
        return strategyModelMapper.getStrategyModelList(uid);
    }

    @Override
    public void updateStrategyModeInfo(StrategyModel strategyModel) throws Exception {
        if (strategyModel.getId() == null) {
            strategyModelMapper.insertStrategyModel(strategyModel);
        } else {
            strategyModelMapper.updateStrategyModel(strategyModel);
        }
    }
}
