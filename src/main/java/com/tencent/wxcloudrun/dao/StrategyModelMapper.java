package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.StrategyModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StrategyModelMapper {

  StrategyModel getStrategyModelList();

  void upsertStrategyModel(StrategyModel strategyModel);

  void deleteStrategyModel(@Param("id") Integer id);
}
