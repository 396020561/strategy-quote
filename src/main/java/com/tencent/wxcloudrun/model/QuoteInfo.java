package com.tencent.wxcloudrun.model;

import com.tencent.wxcloudrun.controller.QuoteController;
import lombok.Data;

@Data
public class QuoteInfo {
    private String stockName; // 名称
    private String stockCode; // 代码
    private String currentPrice; // 当前价格
    private String yesClosePrice; // 昨收价
    private String openPrice; // 金开价
    private String dealAmount; // 成交量（手）
    private String outer; // 外盘
    private String inner; // 内盘
    private String b1; // 买一价
    private String ba1; // 买一量
    private String b2; // 买二价
    private String ba2; // 买二量
    private String b3; // 买三价
    private String ba3; // 买三量
    private String b4; // 买四价
    private String ba4; // 买四量
    private String b5; // 买五价
    private String ba5; // 买五量
    private String s1; // 卖一价
    private String sa1; // 卖一量
    private String s2; // 卖二价
    private String sa2; // 卖三量
    private String s3; // 卖三价
    private String sa3; // 卖三量
    private String s4; // 卖四价
    private String sa4; // 卖四量
    private String s5; // 卖五价
    private String sa5; // 卖五量
    private String lastDeal; // 最近逐笔成交
    private String timestamp; // 时间
    private String rateRage; // 涨跌量
    private String rate; // 涨跌比率%
    private String highPrice; // 最高价
    private String lowPrice; // 最低价
//    private String dealAmount; 价格/成交量（手）/成交额
    private String dealBalance; // 成交额（万）
    private String exchangeRate; // 换手率
    private String peRatio; // 市盈率
    private String amplitude; // 振幅
    private String circMarketVal; // 流通市值
    private String totalMarketVal; // 总市值
    private String priceToBookRatio; // 市净率
    private String tradingLimitPrice; // 涨停价
    private String fallingLimitPrice; // 跌停价

    public QuoteInfo(String[] fields) {
        try {
            this.stockName = fields[1];
            this.stockCode = fields[2];
            this.currentPrice = fields[3];
            this.yesClosePrice = fields[4];
            this.openPrice = fields[5];
            this.dealAmount = fields[6];
            this.outer = fields[7];
            this.inner = fields[8];
            this.b1 = fields[9];
            this.ba1 = fields[10];
            this.b2 = fields[11];
            this.ba2 = fields[12];
            this.b3 = fields[13];
            this.ba3 = fields[14];
            this.b4 = fields[15];
            this.ba4 = fields[16];
            this.b5 = fields[17];
            this.ba5 = fields[18];
            this.s1 = fields[19];
            this.sa1 = fields[20];
            this.s2 = fields[21];
            this.sa2 = fields[22];
            this.s3 = fields[23];
            this.sa3 = fields[24];
            this.s4 = fields[25];
            this.sa4 = fields[26];
            this.s5 = fields[27];
            this.sa5 = fields[28];
            this.lastDeal = fields[29];
            this.timestamp = fields[30];
            this.rateRage = fields[31];
            this.rate = fields[32];
            this.highPrice = fields[33];
            this.lowPrice = fields[34];
            this.dealBalance = fields[37];
            this.exchangeRate = fields[38];
            this.peRatio = fields[39];
            this.amplitude = fields[43];
            this.circMarketVal = fields[44];
            this.totalMarketVal = fields[45];
            this.priceToBookRatio = fields[46];
            this.tradingLimitPrice = fields[47];
            this.fallingLimitPrice = fields[48];
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
