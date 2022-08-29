package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OptionalStock implements Serializable {

  private Integer id;

  private String uid; // 用户编号

  private String stockList; // 股票代码集合

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
