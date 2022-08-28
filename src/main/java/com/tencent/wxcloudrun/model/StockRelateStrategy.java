package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class StockRelateStrategy implements Serializable {

  private Integer id;

  private String stkcode; // 证券代码

  private Integer sid; // 算法策略编号

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
