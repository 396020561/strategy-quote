package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public QuoteController() {
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = "/quoteInfo")
    ApiResponse get(@RequestParam("symbol") String symbol) {
        return ApiResponse.ok(doGet("http://qt.gtimg.cn/q=" + symbol));
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
            //设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            //设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);

            //通过connection连接，获取输入流
            is = connection.getInputStream();
            //封装输入流is，并指定字符集
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

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
        System.out.println("raoteng" + result);
        return result;
    }
}
