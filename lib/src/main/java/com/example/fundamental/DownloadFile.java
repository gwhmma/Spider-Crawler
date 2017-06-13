package com.example.fundamental;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by PC on 2017/6/5.
 */

public class DownloadFile {
     // 根据URL和网页类型生成需要保存的网页的文件名，去除URL中的非文件名字符
    public String getFileNameByUrl(String url, String contentType)
    {
        //移除Http
        url = url.substring(7);
        //text/html 类型
        if(contentType.indexOf("html")!= -1)
        {
            url = url.replaceAll("[\\?/:*|<>\"]","_") + ".html";
            return url;
        }
        // application/pdf 类型
        else
        {
            return url.replaceAll("[\\?/:*|<>\"]","_") + "." + contentType.substring(contentType.lastIndexOf("/") + 1);
        }
    }
    // 保存网页字节数组到本地文件，filePath为要保存的文件的相对地址
    private void saveToLocal(byte[] data, String filePath)
    {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath)));
            for (int i = 0; i < data.length; i++)
            {
                out.write(data[i]);
            }
            out.flush();
            out.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    // 下载URL指向的网页
    public String downloadFile(String url)
    {
        String filePath = null;
        //生成httpclient对象并设置参数
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
        //CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response;
        // 执行http get 请求
        try {
            response = httpClient.execute(httpGet);
            //得到状态码
            int statusCode = response.getStatusLine().getStatusCode();
            //判断状态码
            if(statusCode != HttpStatus.SC_OK)
            {
                System.err.println("Method faild: " + response.getStatusLine());
            }
            HttpEntity entity = response.getEntity();
            //得到响应内容
            byte[] responesBody = EntityUtils.toByteArray(entity);
            //根据URL生成保存时的文件名   D:\CrawlerDowload\temp
            filePath = "D:\\CrawlerDowload\\temp\\" + getFileNameByUrl(url,response.getFirstHeader("Content-Type").getValue());
           // filePath = "D:\\temp" + getFileNameByUrl(url,response.getFirstHeader("Content-Type").getValue());
            saveToLocal(responesBody,filePath);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return filePath;
    }
}
