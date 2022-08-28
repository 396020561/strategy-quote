package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.OptionalStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OptionalStockMapper {

  OptionalStock getOptionalStockByUid(@Param("id") Integer id);

  void upsertOptionalStock(OptionalStock optionalStock);
}
