package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.OptionalStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OptionalStockMapper {

  OptionalStock getOptionalStockByUid(@Param("uid") String uid);

  void upsertOptionalStock(OptionalStock optionalStock);
}
