-- Вставка даних в таблицю компаній
INSERT INTO companies (name, industry, founded_date) VALUES
                                                         ('Company A', 'IT', '2000-01-01'),
                                                         ('Company B', 'Finance', '1995-05-15'),
                                                         ('Company C', 'Healthcare', '2010-11-30');

-- Вставка даних в таблицю працівників
INSERT INTO employees (company_id, first_name, last_name, position, salary, hire_date) VALUES
                                                                                           (1, 'John', 'Doe', 'Software Engineer', 75000.00, '2015-03-20'),
                                                                                           (1, 'Jane', 'Smith', 'QA Analyst', 60000.00, '2018-07-10'),
                                                                                           (2, 'Jenny', 'Rin', 'Designer', 55000.00, '2019-09-12'),
                                                                                           (2, 'Masha', 'Smith', 'Software Engineer', 89000.00, '2016-05-21'),
                                                                                           (3, 'Djemmi', 'Shmiakiwna', 'Dog', 100000, '2015-11-20');
-- Додайте ще дані для інших працівників

-- Вставка даних в таблицю клієнтів
INSERT INTO clients (company_id, name, contact_person, email, phone_number) VALUES
    (1, 'Client X', 'Tom Johnson', 'clientx@email.com', '+1234567890'),
    (2, 'Client Y', 'Alice White', 'clienty@email.com', '+9876543210');
-- Додайте ще дані для інших клієнтів
