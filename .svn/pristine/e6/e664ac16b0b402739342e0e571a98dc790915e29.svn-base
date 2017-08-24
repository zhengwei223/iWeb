package javacommon.ijdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.lanqiao.web.model.Employee;
import org.lanqiao.web.model.EmployeeMapper;

import javacommon.ijdbc.impl.JdbcUtils;

public class JdbcUtilTest {
    private static IJdbcOperation jdbcUtils = JdbcUtils.getInstance();

    public static void main(String[] args) throws SQLException {

        // basic();
        beanListTest();
    }

    private static void basic() throws SQLException {
        ResultSet rs = jdbcUtils.queryForResultSet("select * from employees");
        while (rs.next()) {
            System.out.println(rs.getString("last_name"));
        }
    }

    // 测试结果集转换为对象
    public static void beanListTest() throws SQLException {
        List<Employee> emps = jdbcUtils.queryForList(
                "select * from employees where salary>? and department_id=?",
                new EmployeeMapper(), 1000, 90);
        for (Employee employee : emps) {
            System.out.println(employee);
        }
    }
}
