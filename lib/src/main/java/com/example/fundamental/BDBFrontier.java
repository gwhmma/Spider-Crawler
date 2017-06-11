package com.example.fundamental;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.collections.StoredMap;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.rep.stream.BaseProtocol;

import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by PC on 2017/6/11.
 */

public class BDBFrontier extends AbstractFrontier implements Frontier {
    private StoredMap pendingUrisDB = null;

    //使用默认的路径和缓存大小构造函数
    public BDBFrontier(String homeDirectory) throws DatabaseException,FileNotFoundException
    {
        super(homeDirectory);
        EntryBinding keyBinding = new SerialBinding(javaCatalog,String.class);
        EntryBinding valueBinding = new SerialBinding(javaCatalog,CrawlUrl.class);
        pendingUrisDB = new StoredMap(database, keyBinding, valueBinding, true);
    }

    //获得下一条记录
    public CrawlUrl getNext() throws Exception
    {
        CrawlUrl result = null;
        if (!pendingUrisDB.isEmpty())
        {
            Set entrys = pendingUrisDB.entrySet();
            System.out.println(entrys);
            Entry<String,CrawlUrl> entry = (Entry<String,CrawlUrl>)pendingUrisDB.entrySet().iterator().next();
            result = entry.getValue();
            delete(entry.getKey());
        }
        return result;
    }

    //存入URL
    public boolean putUrl(CrawlUrl url)
    {
        put(url.getOriUrl(),url);
        return true;
    }

    //存入数据库的方法
    protected void put(Object key, Object value)
    {
        pendingUrisDB.put(key,value);
    }

    // 取出
    protected Object get(Object key)
    {
        return pendingUrisDB.get(key);
    }

    //删除
    protected Object delete(Object key)
    {
        return pendingUrisDB.remove(key);
    }

    //根据URL计算键值，可以使用各种压缩算法，包括MD5算法
    private String caculateUrl(String url)
    {
        MD5 md5 = new MD5();
        byte b[] = url.getBytes();
        return md5.getMD5(b);
    }
}
