

CREATE TABLE employee (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    department_id varchar(255),
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


-- Find employee where salary > average (salary) in his department
SELECT * FROM employee  e1 WHERE salary > (SELECT AVG(salary) FROM EMPLOYEE e2 WHERE e1.department_id = e2.department_id);

-- Find employee where salary > average (salary) in his department
SELECT e1.* FROM employee e1 INNER JOIN (SELECT AVG(salary) avg_sal,department_id FROM employee group by
department_id) as e2 on e1.department_id=e2.department_id and e1.salary>e2.avg_sal;

-- Find average salary in every department
SELECT AVG(salary) as avg_sal FROM employee GROUP BY department_id;

-- Find average salary in every department
SELECT AVG(salary) as avg_sal, department_id FROM employee GROUP BY department_id;

-- Find average salary in department 1
SELECT AVG(salary) as avg_sal, department_id FROM employee GROUP BY department_id HAVING department_id = 1;
