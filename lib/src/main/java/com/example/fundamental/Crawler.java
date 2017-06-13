package com.example.fundamental;

import java.util.Set;

/**
 * Created by PC on 2017/6/8.
 */

public class Crawler {
    // 主题爬虫
    private ComputeUrl computeUrl = null;

    public Crawler()
    {
        computeUrl = new PageRankComputeUrl();
    }
    //使用种子初始化URL队列
    private void initCrawlerWithSeeds(String[] seeds)
    {
        for (int i = 0; i < seeds.length; i++)
        {
            LinkQueue.addUnvisitedUrl(seeds[i]);
        }
    }
    //爬取过程
    public void crawling(String[] seeds)
    {
        //初始化URL队列
        initCrawlerWithSeeds(seeds);
        //循环条件: 待抓取的连接不为空，且抓取的网页小于1000
        while (!LinkQueue.unVisitedUrlsEmpty() && LinkQueue.getVisitedUrlNum()<=1000)
        {
            //定义过滤器，提取以http://www.sina.com开头的链接
            LinkFilter filter = new LinkFilter() {
                @Override
                public boolean accept(String url) {               // http://www.sina.com.cn
                    if (url.startsWith("http://www.sina.com.cn")) //  http://www.163.com
                        return true;
                    else
                    return false;
                }
            };
            //队列头URL出队列
            String visitUrl = (String)LinkQueue.unUnvisitedUrlDeQueue();
            if (visitUrl == null)
                continue;
            DownloadFile downloder = new DownloadFile();
            //下载网页
            String content = downloder.downloadFile(visitUrl);
            if (computeUrl.accept(visitUrl,content))
                continue;
            //该URL放入已访问的URL中
            LinkQueue.addVisitedUrl(visitUrl);
            //提取出下载网页中的URL
            Set<String> links = HtmlParserTool.extracLinks(visitUrl,filter);
            //新的未访问的URL入队列
            for (String link : links)
            {
                LinkQueue.addUnvisitedUrl(link);
            }
        }
    }
/*
    public static void main(String[] args)
    {
        Crawler crawler = new Crawler();
        crawler.crawling(new String[]{"http://www.sina.com.cn"});
    }
    */
}
