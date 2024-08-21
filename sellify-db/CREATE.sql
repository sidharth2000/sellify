DROP DATABASE IF EXISTS sellify;

CREATE DATABASE sellify;

USE sellify;

CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50),
    email VARCHAR(100) NOT NULL UNIQUE,
    password CHAR(60) NOT NULL,
    created_on DATETIME NOT NULL,
    modified_on DATETIME NOT NULL
);

CREATE TABLE category (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    parent_id INT NOT NULL,
    FOREIGN KEY(parent_id) REFERENCES category(id)

)