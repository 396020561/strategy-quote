package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.QuoteInfo;

import java.util.ArrayList;
import java.util.List;

public interface QuoteService {

    List queryQuote(String symbol);
}
