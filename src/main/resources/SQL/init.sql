-- Створення таблиці компаній
CREATE TABLE companies (
                           company_id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           industry VARCHAR(100),
                           founded_date DATE
);

-- Створення таблиці працівників
CREATE TABLE employees (
                           employee_id SERIAL PRIMARY KEY,
                           company_id INT REFERENCES companies(company_id),
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           position VARCHAR(100),
                           salary DECIMAL(10, 2),
                           hire_date DATE
);

-- Створення таблиці клієнтів
CREATE TABLE clients (
                         client_id SERIAL PRIMARY KEY,
                         company_id INT REFERENCES companies(company_id),
                         name VARCHAR(100) NOT NULL,
                         contact_person VARCHAR(50),
                         email VARCHAR(100),
                         phone_number VARCHAR(20)
);
