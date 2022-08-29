package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.OptionalStockMapper;
import com.tencent.wxcloudrun.model.OptionalStock;
import com.tencent.wxcloudrun.service.OptionStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;

@Service
public class OptionalStockServiceImpl implements OptionStockService {

    final OptionalStockMapper optionalStockMapper;

    public OptionalStockServiceImpl(@Autowired OptionalStockMapper optionalStockMapper) {
        this.optionalStockMapper = optionalStockMapper;
    }

    @Override
    public OptionalStock queryOptionalStock(String uid) {
        return optionalStockMapper.getOptionalStockByUid(uid);
    }

    @Override
    public void updateOptionalStock(OptionalStock optionalStock) throws Exception {
        if (optionalStock.getId() == null) {
            optionalStockMapper.insertOptionalStock(optionalStock);
        } else {
            optionalStockMapper.updateOptionalStock(optionalStock);
        }
    }
}
