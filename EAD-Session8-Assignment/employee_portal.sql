create database employee_portal;

use employee_portal;

create table employees(
   id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   employee_id VARCHAR(100) NOT NULL,
   firstname VARCHAR(100) NOT NULL,
   lastname VARCHAR(100),
   dob DATE NOT NULL,
   skills VARCHAR(100),
   gender VARCHAR(1) NOT NULL,
   primarycontact VARCHAR(10),
   secondarycontact VARCHAR(10),
   email VARCHAR(100) NOT NULL,
   profileImage VARCHAR(512),
   password VARCHAR(100) NOT NULL,
   status BOOLEAN DEFAULT true,
   UNIQUE(employee_id)
   );
   
CREATE TABLE job_title_master(
   id INT PRIMARY KEY,
   job VARCHAR(100) NOT NULL
   );
   
CREATE TABLE skill_master(
   id INT PRIMARY KEY,
   title VARCHAR(100) NOT NULL
);

CREATE TABLE employee_skills(
   id INT PRIMARY KEY,
   employee_id INT NOT NULL,
   skill_id INT NOT NULL,
   FOREIGN KEY (employee_id)  REFERENCES employees(id),
   FOREIGN KEY (skill_id)  REFERENCES skill_master(id)
);


CREATE TABLE project_master(
   id INT PRIMARY KEY,
   description VARCHAR(200) NOT NULL,
   start_date DATE NOT NULL,
   end_date DATE,
   project_logo VARCHAR(100)
);

CREATE TABLE address(
   id INT PRIMARY KEY,
   employee_id INT NOT NULL,
   add_line_1 VARCHAR(100) NOT NULL,
   add_line_2 VARCHAR(100),
   FOREIGN KEY (employee_id) REFERENCES employees(id)
);

#This Table Is Not Correct
CREATE TABLE job_details(
   emp_code INT NOT NULL,
   job_detail_id INT PRIMARY KEY AUTO_INCREMENT ,
   date_of_joining DATE NOT NULL,
   total_exp INTEGER NOT NULL,
   job_code VARCHAR(100) NOT NULL,
   reproting_mgr INT,
   team_lead INT,
   curr_proj_id INT,
   FOREIGN KEY (emp_code) REFERENCES employees(emp_code),
   FOREIGN KEY (job_code) REFERENCES job_title_master(job_code),
   FOREIGN KEY (reproting_mgr) REFERENCES user_roles(reproting_mgr),
   FOREIGN KEY (team_lead) REFERENCES user_roles(team_lead),
   FOREIGN KEY (curr_proj_id) REFERENCES project_id(curr_proj_id)
);