package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.OptionalStock;

public interface OptionStockService {

    OptionalStock queryOptionalStock(String uid);

    void updateOptionalStock(OptionalStock optionalStock) throws Exception;
}
