 
drop database if exists testdb;
create database if not exists testdb;

use testdb
drop table if exists students;
use testdb
create table  students(
	 _id int primary key not null auto_increment,
	name varchar(20) not null,
	gender varchar(6) not null
 );

insert into students value (1, "jiang", "male");

-- 建立存储过程 MySQL 语法

delimiter //
CREATE PROCEDURE simpleproc (OUT para1 INT)
BEGIN
	SELECT COUNT(*) INTO para1 FROM t;
END
// 
delimiter;

