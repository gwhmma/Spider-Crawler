package com.example.fundamental;

import java.io.Serializable;
//import java.security.Timestamp;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by PC on 2017/6/8.
 */

public class CrawlUrl implements Serializable {
    private static final long serialVersionUID = 1042333249002072138L;

    private String oriUrl;  //原始URL的值，主机部分是域名
    private String url;      //URL的值，主机部分是IP，为了防止重复主机的出现
    private int urlNo;     //URL num
    private int statusCode;   //获取URL返回的结果码
    private int hitNum;   //此URL被其他文章引用的次数
    private String charSet;      //此URL对应文章的汉子编码
    private String abstractText;   //文章摘要
    private String author;   //作者
    private int weight;    //文章的权重
    private String description;    //文章描述
    private int fileSize;     // 文章大小
    private Timestamp lastUpdateTime;    //最后修改时间
    private Date timeToLive;    //过期时间
    private String title;   //文章名称
    private String type;    //文章类型
    private String[] urlRefrences;    //引用的链接
    private int layer;   //爬取的层次，从种子开始，依次为第0层，第1层....


    public CrawlUrl()
    {

    }

    public int getLayer()
    {
        return layer;
    }
    public void setLayer(int layer)
    {
        this.layer = layer;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public int getUrlNo()
    {
        return urlNo;
    }
    public void setUrlNo(int urlNo)
    {
        this.urlNo = urlNo;
    }
    public int getStatusCode()
    {
        return statusCode;
    }
    public void setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
    }
    public int getHitNum()
    {
        return hitNum;
    }
    public void setHitNum(int hitNum)
    {
        this.hitNum = hitNum;
    }
    public String getCharSet()
    {
        return charSet;
    }
    public void setCharSet(String charSet)
    {
        this.charSet = charSet;
    }
    public String getAbstractText()
    {
        return abstractText;
    }
    public void setAbstractText(String abstractText)
    {
        this.abstractText = abstractText;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public int getFileSize()
    {
        return fileSize;
    }
    public void setFileSize(int fileSize)
    {
        this.fileSize = fileSize;
    }
    public Timestamp getLastUpdateTime()
    {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Timestamp lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }
    public Date getTimeToLive()
    {
        return timeToLive;
    }
    public void setTimeToLive(Date timeToLive)
    {
        this.timeToLive = timeToLive;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String[] getUrlRefrences()
    {
        return urlRefrences;
    }
    public void setUrlRefrences(String[] urlRefrences)
    {
        this.urlRefrences = urlRefrences;
    }
    public String getOriUrl()
    {
        return oriUrl;
    }
    public void setOriUrl(String oriUrl)
    {
        this.oriUrl = oriUrl;
    }
}
