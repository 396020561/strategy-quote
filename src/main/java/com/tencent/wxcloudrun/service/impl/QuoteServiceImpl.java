package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.QuoteInfo;
import com.tencent.wxcloudrun.service.QuoteService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Override
    public List queryQuote(String symbol) {
        String quoteStr = doGet("http://qt.gtimg.cn/q=" + symbol);
        List res = new ArrayList();
        if (!"v_pv_none_match=\"1\";".equals(quoteStr)) {
            Arrays.stream(quoteStr.split(";")).forEach((item) -> {
                String[] fields = item.split("~");
                if (fields.length > 50) {
                    QuoteInfo info = new QuoteInfo(fields);
                    res.add(info);
                }
            });
        }
        return res;
    }

    /**
     * GET请求
     */
    public static String doGet(String httpUrl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;//返回结果字符串

        try {
            //创建远程url连接对象
            URL url = new URL(httpUrl);
            //通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            //设置连接方式：get
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Charset", "GBK");
            //设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);

            //通过connection连接，获取输入流
            is = connection.getInputStream();
            //封装输入流is，并指定字符集
            br = new BufferedReader(new InputStreamReader(is, "GBK"));

            //存放数据
            StringBuffer sbf = new StringBuffer();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sbf.append(temp);
                sbf.append("\r\n");//回车+换行
            }

            result = sbf.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();//关闭远程连接
        }
        return result;
    }
}
