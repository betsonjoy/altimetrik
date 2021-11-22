drop table if exists employee;
drop table if exists department;
drop table if exists project;

create table employee(
	employee_id VARCHAR(20) PRIMARY KEY,
	employee_name VARCHAR(100)
);
create table department(
	department_id VARCHAR(20) PRIMARY KEY,
	department_name VARCHAR(100),
	employee_id VARCHAR(20),
	FOREIGN KEY(employee_id) REFERENCES employee
);
create table project(
	id int PRIMARY KEY,
	project_id VARCHAR(20),
	project_name VARCHAR(100),
	department_id VARCHAR(20),
	employee_id VARCHAR(20),
	FOREIGN KEY(employee_id) REFERENCES employee,
	FOREIGN KEY(department_id) REFERENCES department
);

insert into employee(employee_id, employee_name) values('E10001','Betson Joy');
insert into employee(employee_id, employee_name) values('E10002','Steve Jobs');
insert into employee(employee_id, employee_name) values('E10003','Elon Musk');

insert into department(department_id, department_name,employee_id) values('D1001','Technology','E10001');
insert into department(department_id, department_name,employee_id) values('D1002','Manufactoring','E10003');
insert into department(department_id, department_name,employee_id) values('D1003','Automobile','E10002');
insert into department(department_id, department_name,employee_id) values('D1004','Communication','E10002');

insert into project(id,project_id, project_name,employee_id,department_id) values(1,'P10001','Digitalization','E10001','D1001');
insert into project(id,project_id, project_name,employee_id,department_id) values(2,'P10002','Microservices','E10001','D1001');
insert into project(id,project_id, project_name,employee_id,department_id) values(3,'P10002','Mobile Apps','E10002','D1004');
insert into project(id,project_id, project_name,employee_id,department_id) values(4,'P10003','Gadgets','E10002','D1004');
insert into project(id,project_id, project_name,employee_id,department_id) values(5,'P10004','Electric Vehicle','E10002','D1003');
insert into project(id,project_id, project_name,employee_id,department_id) values(6,'P10005','Fosil Energy Vehicle','E10003','D1002');