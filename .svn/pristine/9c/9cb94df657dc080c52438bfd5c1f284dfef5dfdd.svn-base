package javacommon.ijdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.ijdbc.IJdbcOperation;
import javacommon.ijdbc.RowMapper;
import javacommon.ijdbc.impl.DataSourceFactory.DataSourceType;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简易JDBC操作的实现类
 * 
 * @author shadow
 * 
 */
public class JdbcUtils implements IJdbcOperation {
    private static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);
    private static JdbcUtils obj;
    
    public static IJdbcOperation getInstance(DataSource dataSource){
        if(obj==null){
            synchronized (JdbcUtils.class) {
                if (obj==null) {
                    obj=new JdbcUtils(dataSource);
                }           
            }
        }
        return obj;
    }
    public static IJdbcOperation getInstance(){
        
        return getInstance(DataSourceFactory.getDataSource(DataSourceType.SIMPLE));
    }
    private DataSource dataSource;

    private JdbcUtils() {

    }

    private JdbcUtils(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private PreparedStatement createPreparedStatement(Connection conn,
            String sql, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++)
            stmt.setObject(i + 1, params[i]);
        if (logger.isDebugEnabled()) {
            logger.debug(sql);
        }
        return stmt;
    }

    @Override
    public int execute(String sql, Object... params) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        int result = -1;
        try {
            stmt = createPreparedStatement(conn, sql, params);
            result = stmt.executeUpdate();
        } finally {
            free(stmt);
            free(conn);
        }
        return result;
    }

    @Override
    public int[] executeBatch(String[] sqls) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        int[] result = null;
        try {
            conn = getConnection(false);
            stmt = conn.createStatement();
            for (int i = 0; i < sqls.length; i++) {
                stmt.addBatch(sqls[i]);
            }
            result=stmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw e;
            } catch (SQLException e1) {
                throw e;
            }
        } finally {
            free(stmt);
            free(conn);
        }
        return result;
    }

    @Override
    public int executeBatch(String[] sqls, Object[][] params)
            throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = -1;
        try {
            conn = getConnection(false);
            for (int i = 0; i < sqls.length; i++) {
                stmt = createPreparedStatement(conn, sqls[i], params[i]);
                result += stmt.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw e;
            } catch (SQLException e1) {
                throw e;
            }
        } finally {
            free(stmt);
            free(conn);
        }
        return result;
    }

    @Override
    public void free(Connection x) {
        if (x != null)
            try {
                x.close();
            } catch (SQLException e) {
                // e.printStackTrace();
            }
    }

    @Override
    public void free(PreparedStatement x) {
        if (x != null)
            try {
                x.close();
            } catch (SQLException e) {
                // e.printStackTrace();
            }
    }

    @Override
    public void free(ResultSet x) {
        if (x != null)
            try {
                x.close();
            } catch (SQLException e) {
                // e.printStackTrace();
            }
    }

    @Override
    public void free(Statement x) {
        if (x != null)
            try {
                x.close();
            } catch (SQLException e) {
                // e.printStackTrace();
            }
    }

    public Connection getConnection() throws SQLException {
        return getConnection(true);
    }

    public Connection getConnection(boolean autoCommit) throws SQLException {
        Connection conn = dataSource.getConnection();
        if (!autoCommit)
            conn.setAutoCommit(autoCommit);
        return conn;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public double queryForDouble(String sql, Object... params)
            throws SQLException {
        ResultSet rs = null;
        try {
            rs = queryForResultSet(sql, params);
            if (rs.next()) {
                return rs.getDouble(1);
            } else {
                throw new SQLException("无结果");
            }
        } finally {
            free(rs);
        }
    }

    @Override
    public long queryForFloat(String sql, Object... params) throws SQLException {
        ResultSet rs = null;
        try {
            rs = queryForResultSet(sql, params);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("无结果");
            }
        } finally {
            free(rs);
        }
    }

    @Override
    public int queryForInt(String sql, Object... params) throws SQLException {
        ResultSet rs = null;
        try {
            rs = queryForResultSet(sql, params);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("无结果");
            }
        } finally {
            free(rs);
        }
    }

    @Override
    public <T> List<T> queryForList(String sql, RowMapper<T> mapper,
            Object... params) throws SQLException {
        ResultSet rs = null;
        List<T> list = null;
        try {
            rs = queryForResultSet(sql, params);
            list = new ArrayList<T>();
            while (rs.next()) {
                list.add(mapper.mapRow(rs));
            }
        } finally {
            free(rs);
        }
        return list;
    }

    @Override
    public long queryForLong(String sql, Object... params) throws SQLException {
        ResultSet rs = null;
        try {
            rs = queryForResultSet(sql, params);
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("无结果");
            }
        } finally {
            free(rs);
        }
    }

    @Override
    public Map<Object, Object> queryForMap(String sql, Object... params)
            throws SQLException {
        ResultSet rs = null;
        try {
            rs = queryForResultSet(sql, params);
            Map<Object, Object> map = new HashMap<Object, Object>();
            while (rs.next()) {
                map.put(rs.getObject(1), rs.getObject(2));
            }
            return map;
        } finally {
            free(rs);
        }
    }

    @SuppressWarnings("restriction")
    @Override
    public ResultSet queryForResultSet(String sql, Object... params)
            throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = createPreparedStatement(conn, sql, params);
            rs = stmt.executeQuery();
            // 提供缓存功能
            CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl();
            crs.populate(rs);
            return crs;
        } finally {
            free(rs);
            free(stmt);
            free(conn);
        }
    }

    @Override
    public String queryForString(String sql, Object... params)
            throws SQLException {
        ResultSet rs = null;
        try {
            rs = queryForResultSet(sql, params);
            if (rs.next()) {
                return rs.getString(1);
            } else {
                throw new SQLException("无结果");
            }
        } finally {
            free(rs);
        }
    }

    @Override
    public <T> T queryForUniqueBean(String sql, RowMapper<T> mapper,
            Object... params) throws SQLException {
        ResultSet rs = null;
        List<T> list = null;
        try {
            rs = queryForResultSet(sql, params);
            if (rs.next()) {
                return mapper.mapRow(rs);
            } else {
                throw new SQLException("无结果");
            }
        } finally {
            free(rs);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
