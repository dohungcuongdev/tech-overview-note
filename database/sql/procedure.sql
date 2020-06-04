DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP PROCEDURE IF EXISTS GetAllEmployees;
DROP PROCEDURE IF EXISTS GetEmployeeByNameAndDepartmentId;
DROP PROCEDURE IF EXISTS CheckEmloyeeSalaryGreaterThanAverageSalary;

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

DELIMITER //
CREATE PROCEDURE GetAllEmployees()
BEGIN
	SELECT *  FROM employee;
END //
DELIMITER ;

CALL GetAllEmployees;

DELIMITER //
CREATE PROCEDURE GetEmployeeByNameAndDepartmentId
(
   name varchar(255),
   department_id int
) 
BEGIN 
   SELECT * FROM employee 
   WHERE employee.name=name 
   AND employee.department_id=department_id; 
END; //
DELIMITER ;

CALL GetEmployeeByNameAndDepartmentId('cuong', 1);


DELIMITER //
CREATE PROCEDURE CheckEmloyeeSalaryGreaterThanAverageSalary(
	in employee_id int
)
BEGIN
	DECLARE AVG_SAL, EMP_SAL INT DEFAULT 0;
	DECLARE MESSAGE varchar(255) DEFAULT '';
	SELECT AVG(salary) INTO AVG_SAL FROM employee;
	SELECT salary INTO EMP_SAL FROM employee WHERE id = employee_id;
	IF(EMP_SAL <= AVG_SAL) THEN 
        SET MESSAGE = CONCAT('salary of employee = ',EMP_SAL,' <= average salary = ',AVG_SAL);
		SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = MESSAGE;
	ELSE
	    SELECT CONCAT('salary of employee = ',EMP_SAL,' > average salary = ',AVG_SAL);
	END IF;
END; //
DELIMITER ;

CALL CheckEmloyeeSalaryGreaterThanAverageSalary(1);