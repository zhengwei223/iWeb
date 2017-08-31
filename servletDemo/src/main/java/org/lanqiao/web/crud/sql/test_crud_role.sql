CREATE TABLE crud_role
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(20)
);

INSERT INTO test.crud_role (name) VALUES ('管理员');
INSERT INTO test.crud_role (name) VALUES ('群众');