package com.example.fundamental;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PC on 2017/6/5.
 */

public class LinkQueue {
    //已访问的URL集和
    private static Set visitedUrl = new HashSet();
    //等待访问的URL集和
    private static Queue unVisitedUrl = new Queue();
    //获得URL队列
    public static Queue getUnVisitedUrl()
    {
        return unVisitedUrl;
    }
    //添加到访问过的URL队列
    public static void addVisitedUrl(String url)
    {
        visitedUrl.add(url);
    }
    //移除访问过的URL
    public static void removeVisitedUrl(String url)
    {
        visitedUrl.remove(url);
    }
    //未访问的URL出队列
    public static Object unUnvisitedUrlDeQueue()
    {
        return unVisitedUrl.deQueue();
    }
    //保证每个URL只被访问一次
    public static void addUnvisitedUrl(String url)
    {
        if(url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.isContains(url))
            unVisitedUrl.enQueue(url);
    }
    //获得已经访问过的URL数量
    public static int getVisitedUrlNum()
    {
        return visitedUrl.size();
    }
    //判断未访问的URL队列是否为空
    public static boolean unVisitedUrlsEmpty()
    {
        return unVisitedUrl.isQueueEmpty();
    }
}
