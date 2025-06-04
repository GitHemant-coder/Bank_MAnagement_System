CREATE DATABASE bankmanagementsystem;

USE bankmanagementsystem;

CREATE TABLE signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20),email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25));
SELECT * FROM signup;
DROP TABLE signup;

CREATE TABLE signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingaccount varchar(20));
SELECT * FROM signuptwo;
DROP TABLE signuptwo;

CREATE TABLE signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100));
SELECT * FROM signupthree;
DROP TABLE signupthree;

CREATE TABLE login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
SELECT * FROM login;
DROP TABLE bank;

CREATE TABLE bank( pin varchar(10), date varchar(100), type varchar(20), amount varchar(20) );
SELECT * FROM bank;
DROP TABLE bank;