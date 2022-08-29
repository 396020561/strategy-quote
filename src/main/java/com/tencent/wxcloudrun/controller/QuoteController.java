package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@CrossOrigin
@RestController
public class QuoteController {
    final Logger logger;
    private QuoteService quoteService;

    public QuoteController(@Autowired QuoteService quoteService) {
        this.logger = LoggerFactory.getLogger(CounterController.class);
        this.quoteService = quoteService;
    }

    /**
     * 获取股票行情
     * @return API response json
     */
    @GetMapping(value = "/quoteInfo")
    ApiResponse get(@RequestParam("symbol") String symbol) {
        this.logger.info("获取证券代码行情->" + symbol);
        return ApiResponse.ok(quoteService.queryQuote(symbol));
    }
}
