package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.StockRelateStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockRelateStrategyMapper {

  StockRelateStrategy getStrategyByStockCode(@Param("stkcode") String stkcode);

  StockRelateStrategy getStockByStrategyId(@Param("sid") Integer sid);

  void upsertStockRelateStrategy(StockRelateStrategy stockRelateStrategy);

  void deleteStockRelateStrategy(@Param("id") Integer id);
}
