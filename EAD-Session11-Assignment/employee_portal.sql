create database employee_portal;

use employee_portal;

create table employees(
   id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   employee_id VARCHAR(100) NOT NULL,
   firstname VARCHAR(100) NOT NULL,
   lastname VARCHAR(100),
   dob DATE NOT NULL,
   skills INT,
   gender VARCHAR(45) NOT NULL,
   primarycontact VARCHAR(10) NOT NULL,
   secondarycontact VARCHAR(10),
   email VARCHAR(100) NOT NULL,
   profileImage VARCHAR(512),
   password VARCHAR(100) NOT NULL,
   status BOOLEAN DEFAULT true,
   UNIQUE(employee_id)
   );
   

   
CREATE TABLE job_details(
  id INT PRIMARY KEY AUTO_INCREMENT,
  employee_id INT NOT NULL,
  job_id INT NOT NULL,
  reporting_manager INT,
  team_lead INT,
  project_id INT,
  FOREIGN KEY (employee_id) REFERENCES employees(id),
  FOREIGN KEY (job_id) REFERENCES job_title_master(id),
  FOREIGN KEY (reporting_manager) REFERENCES employees(id),
  FOREIGN KEY (team_lead) REFERENCES employees(id),
  FOREIGN KEY (project_id) REFERENCES project_master(id)
);
     
CREATE TABLE job_title_master(
   id INT PRIMARY KEY AUTO_INCREMENT,
   job VARCHAR(100) NOT NULL
   );
   
CREATE TABLE skill_master(
   id INT PRIMARY KEY AUTO_INCREMENT,
   title VARCHAR(100) NOT NULL
);

desc skill_relation;

CREATE TABLE employee_skills(
   id INT PRIMARY KEY AUTO_INCREMENT,
   employee_id INT NOT NULL,
   skill_id INT NOT NULL,
   FOREIGN KEY (employee_id)  REFERENCES employees(id),
   FOREIGN KEY (skill_id)  REFERENCES skill_master(id)
);


CREATE TABLE project_master(
   id INT PRIMARY KEY AUTO_INCREMENT,
   description VARCHAR(200) NOT NULL,
   start_date DATE NOT NULL,
   end_date DATE,
   project_logo VARCHAR(100),
   name VARCHAR(45) NOT NULL
);

CREATE TABLE address(
   id INT PRIMARY KEY,
   employee_id INT NOT NULL,
   add_line_1 VARCHAR(100) NOT NULL,
   add_line_2 VARCHAR(100),
   FOREIGN KEY (employee_id) REFERENCES employees(id)
);
