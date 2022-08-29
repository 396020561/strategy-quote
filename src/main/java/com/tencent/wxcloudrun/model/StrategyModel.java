package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class StrategyModel implements Serializable {

  private Integer id;

  private String uid; // 所属用户

  private String name; // 算法名称

  private String formula; // 算法公式

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
