package com.example.fundamental;

import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by PC on 2017/6/9.
 */

public abstract class AbstractFrontier {
    private Environment env;
    private static final String CLASS_CATALOG = "java_class_catalog";
    protected StoredClassCatalog javaCatalog;
    protected Database catalogdatabase;
    protected Database database;

    public AbstractFrontier(String homeDirectory) throws DatabaseException,FileNotFoundException
    {
        //打开env
        System.out.println("opening envirment in:" + homeDirectory);
        EnvironmentConfig environmentConfig = new EnvironmentConfig();
        environmentConfig.setTransactional(true);
        environmentConfig.setAllowCreate(true);
        env = new Environment(new File(homeDirectory),environmentConfig);
        //设置databaseConfig
        DatabaseConfig databaseConfig = new DatabaseConfig();
        databaseConfig.setTransactional(true);
        databaseConfig.setAllowCreate(true);
        //打开
        catalogdatabase = env.openDatabase(null,CLASS_CATALOG,databaseConfig);
        javaCatalog = new StoredClassCatalog(catalogdatabase);
        //设置DatabaseConfig
        DatabaseConfig databaseConfig1 = new DatabaseConfig();
        databaseConfig1.setTransactional(true);
        databaseConfig1.setAllowCreate(true);
        database = env.openDatabase(null,"URL",databaseConfig1);
    }
    //关闭数据库，关闭环境
    public void close() throws DatabaseException
    {
        database.close();
        javaCatalog.close();
        env.close();
    }
    //put方法
    protected abstract void put(Object key, Object value);
    //get方法
    protected abstract Object get(Object key);
    //delete方法
    protected abstract Object delete(Object key);
}
