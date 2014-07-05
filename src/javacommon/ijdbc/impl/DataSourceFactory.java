package javacommon.ijdbc.impl;

import javacommon.ijdbc.exception.UnImplementionException;

import javax.sql.DataSource;
/**
 * 工厂模式用于屏蔽底层实现,DataSource的实现类名应该对外界屏蔽
 * @author JBoss
 *
 */
public class DataSourceFactory {
    public static enum DataSourceType{
        SIMPLE,DBCP,JNDI;
    }
    public static DataSource getDataSource(DataSourceType type ) {
        switch (type) {
        case DBCP:
            throw new UnImplementionException("DBCP");
        case JNDI:
            throw new UnImplementionException("JNDI");
        case SIMPLE:
            return SimpleDataSource.getInstance();
        default:
            throw new UnImplementionException();
        }
    }
}
