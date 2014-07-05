package javacommon.ijdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * JDBC操作接口
 * 
 * @author JBoss
 * @version 2014.6.17
 */
public interface IJdbcOperation {

    /**
     * 增删改功能
     * 
     * @param sql
     *            sql语句
     * @param params
     *            sql中的参数
     * @return 变更记录数
     * @throws SQLException
     */
    int execute(String sql, Object... params)
            throws SQLException;

    /**
     * 批处理增删改
     * 
     * @param sql
     *            多个带参sql
     * @param params
     *            参数
     * @return 变更记录数
     * @throws SQLException
     */
    int executeBatch(String[] sql, Object[][] params)
            throws SQLException;

    /**
     * 批处理增删改
     * 
     * @param sql
     *            多个不带参的sql
     * @param params
     *            参数
     * @return 变更记录数
     * @throws SQLException
     */
    int[] executeBatch(String[] sql) throws SQLException;

    /**
     * select功能
     * 
     * @param sql
     *            sql语句
     * @param params
     *            参数
     * @return 原生ResultSet数据集合
     * @throws SQLException
     */
    ResultSet queryForResultSet(String sql, Object... params)
            throws SQLException;

    /**
     * select功能,提供对象映射规则,将结果集转换为对象列表
     * 
     * @param sql
     *            sql语句
     * @param mapper
     *            提供映射规则的对象
     * @param params
     *            sql参数
     * @return List<?>数据集合
     * @throws SQLException
     */
    <T> List<T> queryForList(String sql, RowMapper<T> mapper,
            Object... params) throws SQLException;

    /**
     * select功能,针对只返回一行或者只需返回一行的数据进行封装
     * 
     * @param sql
     *            sql语句
     * @param mapper
     *            提供映射规则的对象
     * @param params
     *            sql参数
     * @return 泛型所执行的类型的对象
     * @throws SQLException
     */
    <T> T queryForUniqueBean(String sql, RowMapper<T> mapper,
            Object... params) throws SQLException;

    /**
     * select功能,取查询结果的前两列,作为map中元素的键和值
     * 
     * @param sql
     *            sql语句
     * @param params
     *            sql参数
     * @return 由查询的第一列和第二列组成键值对的map
     * @throws SQLException
     */
    Map<Object, Object> queryForMap(String sql,
            Object... params) throws SQLException;

    /**
     * select功能,针对返回的单行,取第一列(一般调用者只查询一列),转换为int
     * 
     * @param sql
     * @return 所查询的整数值
     * @throws SQLException
     */
    int queryForInt(String sql, Object... params)
            throws SQLException;

    /**
     * select功能,针对返回的单行,取第一列(一般调用者只查询一列),转换为Float
     * 
     * @param sql
     * @return 所查询的Float
     * @throws SQLException
     */
    long queryForFloat(String sql, Object... params)
            throws SQLException;

    /**
     * select功能,针对返回的单行,取第一列(一般调用者只查询一列),转换为Double
     * 
     * @param sql
     * @return 所查询的Double
     * @throws SQLException
     */
    double queryForDouble(String sql, Object... params)
            throws SQLException;

    /**
     * select功能,针对返回的单行,取第一列(一般调用者只查询一列),转换为long
     * 
     * @param sql
     * @return 所查询的长整型数值
     * @throws SQLException
     */
    long queryForLong(String sql, Object... params)
            throws SQLException;

    /**
     * select功能,针对返回的单行,取第一列(一般调用者只查询一列),转换为String
     * 
     * @param sql
     * @return 所查询的字符串
     * @throws SQLException
     */
    String queryForString(String sql, Object... params)
            throws SQLException;

    /**
     * 释放Connection资源
     * 
     * @param x
     */
    void free(Connection x);

    /**
     * 释放Statement资源
     * 
     * @param x
     */
    void free(Statement x);

    /**
     * 释放PreparedStatement资源
     * 
     * @param x
     */
    void free(PreparedStatement x);

    /**
     * 释放ResultSet资源
     * 
     * @param x
     */
    void free(ResultSet x);

    /**
     * 设置数据源
     * 
     * @param dataSource
     */
    void setDataSource(DataSource dataSource);

    /**
     * 获取数据库链接
     * 
     * @return Connection对象
     * @throws SQLException 
     */
    Connection getConnection() throws SQLException;

    /**
     * 获取数据库链接
     * 
     * @param autoCommit
     *            是否自动提交
     * @return Connection对象
     * @throws SQLException 
     */
    Connection getConnection(boolean autoCommit) throws SQLException;

}
