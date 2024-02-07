-- Создание таблицы ролей и вставка данных
CREATE TABLE IF NOT EXISTS roles (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     role VARCHAR(255) NOT NULL
    );

INSERT INTO roles (id, role)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

-- Создание таблицы пользователей и вставка данных
CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     age INT,
                                     email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255) NOT NULL
    );

INSERT INTO users (id, age, email, first_name, last_name, password)
VALUES (1, 55, 'admin@gmail.com', 'admin', 'admin', '$2a$12$J50zihjR.M.foOg6lJ8hdeu3SZc1myn7px6V1fSQhCcs7pwV5U9Ui');

-- Создание таблицы пользователь-роли и вставка данных
CREATE TABLE IF NOT EXISTS users_roles (
                                           user_id INT NOT NULL,
                                           role_id INT NOT NULL,
                                           PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
    );

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 2);
