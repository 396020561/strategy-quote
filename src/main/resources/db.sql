-- 算法策略表
drop table if exists StrategyModel;
CREATE TABLE `StrategyModel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(16) NOT NULL DEFAULT '',
  `name` char(11) NOT NULL DEFAULT '默认策略名',
  `formula` varchar(256) NOT NULL DEFAULT '[]',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 算法策略与股票关联表
drop table if exists StockRelateStrategy;
CREATE TABLE `StockRelateStrategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(11) NOT NULL DEFAULT '',
  `stkcode` varchar(8) NOT NULL DEFAULT '',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 自选股票表
drop table if exists OptionalStock;
CREATE TABLE `OptionalStock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(16) NOT NULL DEFAULT '',
  `stockList` varchar(128) NOT NULL DEFAULT '',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;