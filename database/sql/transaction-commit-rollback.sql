DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    department_id int,
    salary int,
    PRIMARY KEY (id)
);

insert into employee (name, department_id, salary) values ('cuong', 1, 2000);
insert into employee (name, department_id, salary) values ('huy', 2, 300);
insert into employee (name, department_id, salary) values ('hoang', 3, 500);
insert into employee (name, department_id, salary) values ('ha', 1, 600);
insert into employee (name, department_id, salary) values ('hai', 2, 800);
insert into employee (name, department_id, salary) values ('hieu', 3, 100);
insert into employee (name, department_id, salary) values ('phong', 1, 400);
insert into employee (name, department_id, salary) values ('phuc', 2, 700);
insert into employee (name, department_id, salary) values ('hoa', 3, 900);
insert into employee (name, department_id, salary) values ('hong', 2, 600);
insert into employee (name, department_id, salary) values ('hao', 2, 650);
insert into employee (name, department_id, salary) values ('hanh', 5, 650);

START TRANSACTION;
INSERT INTO employee (name, department_id, salary) VALUES ('This one would be discarded on rollback', 1, 1);
ROLLBACK;
INSERT INTO employee (name, department_id, salary) VALUES ('This one will be permanent because not within transaction', 1, 1);

SET autocommit = 0;
START TRANSACTION;
INSERT INTO employee (name, department_id, salary) VALUES ('This one would be discarded without commit', 1, 1); 

SET autocommit = 0;
START TRANSACTION;
INSERT INTO employee (name, department_id, salary) VALUES ('This one would be permanent with commit', 1, 1);  
COMMIT;
	

SET autocommit = 1;
