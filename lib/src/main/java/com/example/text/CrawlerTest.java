package com.example.text;

import com.example.fundamental.Crawler;

/**
 * Created by PC on 2017/6/13.
 */

public class CrawlerTest {
    public static void main(String[] args)
    {
        Crawler crawler = new Crawler();
        crawler.crawling(new String[]{"http://www.sina.com.cn"});
    }
}
