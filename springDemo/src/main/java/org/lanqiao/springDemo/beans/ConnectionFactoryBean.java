package org.lanqiao.springDemo.beans;

import org.springframework.beans.factory.FactoryBean;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
  private DataSource dataSource;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Connection getObject() throws Exception {
    return dataSource.getConnection();
  }

  public Class<?> getObjectType() {
    return Connection.class;
  }

  public boolean isSingleton() {
    return true;
  }
}
