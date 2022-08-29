package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.StrategyModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StrategyModelMapper {

  List<StrategyModel> getStrategyModelList(@Param("uid") String uid);

  List<StrategyModel> getStrategyModelListByStock(@Param("stkcode") String stockCode);

  void upsertStrategyModel(StrategyModel strategyModel);

  void deleteStrategyModel(@Param("id") Integer id);
}
