package com.example.text;

import com.example.fundamental.BDBFrontier;
import com.example.fundamental.CrawlUrl;

import java.io.FileNotFoundException;

/**
 * Created by PC on 2017/6/13.
 */

public class BDBFrotierTest {

    public static void main(String[] args)
    {
        try {
            BDBFrontier bdbFrontier = new BDBFrontier("D:\\CrawlerDowload\\BDB");
            CrawlUrl url = new CrawlUrl();
            url.setOriUrl("http://www.baidu.com");
            bdbFrontier.putUrl(url);
            System.out.println(((CrawlUrl)bdbFrontier.getNext()).getOriUrl());
            bdbFrontier.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
