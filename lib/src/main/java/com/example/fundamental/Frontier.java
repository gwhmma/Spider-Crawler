package com.example.fundamental;

/**
 * Created by PC on 2017/6/9.
 */

public interface Frontier {
    public CrawlUrl getNext() throws Exception;
    public boolean putUrl(CrawlUrl url) throws Exception;
}
