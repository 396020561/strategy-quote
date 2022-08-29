package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.StrategyModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface StrategyModelMapper {

  ArrayList getStrategyModelList(@Param("uid") String uid);

  ArrayList getStrategyModelListByStock(@Param("stkcode") String stockCode);

  void upsertStrategyModel(StrategyModel strategyModel);

  void deleteStrategyModel(@Param("id") Integer id);
}
