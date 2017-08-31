-- servlet和jsp示例需要的表结构和数据
DROP TABLE IF EXISTS t_employee;
CREATE TABLE t_employee(
  id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(20),
  last_name VARCHAR(64)
);

INSERT INTO t_employee (first_name, last_name) VALUES ('张三','尼古拉斯');
INSERT INTO t_employee (first_name, last_name) VALUES ('赵六','尼古拉斯');
INSERT INTO t_employee (first_name, last_name) VALUES ('王二','斯蒂芬');