DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

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


CREATE TABLE department (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

delete from department;
ALTER TABLE department AUTO_INCREMENT = 1;
insert into department (name) values ('department A');
insert into department (name) values ('department B');
insert into department (name) values ('department C');
insert into department (name) values ('department D');

-- SELECT * FROM employee UNION SELECT * FROM department --
-- problem: The used SELECT statements have a different number of columns --

SELECT * FROM `employee` UNION SELECT * FROM `employee`;

SELECT * FROM `employee` where id = 1 UNION SELECT * FROM `employee` where id = 2;
SELECT * FROM `employee` where id = 1 or id = 2;
SELECT * FROM `employee` where id in (1, 2);

-- select employee with salary > 100 or id = 2
SELECT * FROM `employee` where salary > 400 UNION SELECT * FROM `employee` where id = 2;

SELECT "All Employees" AS name from employee
UNION
SELECT name from employee;