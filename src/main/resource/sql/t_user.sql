-- servlet和jsp示例需要的表结构和数据

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20),
  password VARCHAR(64)
);

INSERT INTO t_user (username, password) VALUES ('zhangsan','123456');