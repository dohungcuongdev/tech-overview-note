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
insert into employee (name, department_id, salary) values ('hanh', 5, 650);

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

-- inner join --
SELECT * FROM employee e join department d on e.department_id = d.id;
SELECT * FROM employee e inner join department d on e.department_id = d.id; -- join and inner join are functionally equivalent, but INNER JOIN can be a bit clearer to read, especially if the query has other join types (i.e. LEFT or RIGHT or CROSS) included in it. --


-- outter join --
SELECT * FROM employee e left join department d on e.department_id = d.id;
SELECT * FROM employee e right join department d on e.department_id = d.id; --
-- SELECT * FROM employee e full outter join department d on e.department_id = d.id; --
-- You don't have FULL JOINS on MySQL, but you can sure emulate them. --
SELECT * FROM employee e
LEFT JOIN department d ON e.department_id = d.id
UNION
SELECT * FROM employee e
RIGHT JOIN department d ON e.department_id = d.id;