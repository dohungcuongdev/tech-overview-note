DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employee_audit;
DROP TRIGGER IF EXISTS before_employee_update;

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

-- this table is created to check the update history of employee --
CREATE TABLE employee_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    name varchar(255) NOT NULL,
    department_id INT,
    salary int,
    change_date DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);

-- CREATE TRIGGER trigger_name --
-- {BEFORE | AFTER} {INSERT | UPDATE| DELETE } --
-- ON table_name FOR EACH ROW --
-- trigger_body; --

CREATE TRIGGER before_employee_update 
    BEFORE UPDATE ON employee
    FOR EACH ROW 
 INSERT INTO employee_audit
 SET action = 'update',
     employee_id = OLD.id,
     name = OLD.name,
     department_id = OLD.department_id,
     salary = OLD.salary,
     change_date = NOW();
	 
UPDATE employee set name = 'do cuong' where id = 1;
UPDATE employee set name = 'do huy', department_id = 5, salary = 500 where id = 2;

-- check data --
SELECT * FROM employee;
SELECT * FROM employee_audit;
