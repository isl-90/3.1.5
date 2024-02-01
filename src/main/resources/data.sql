INSERT INTO roles(id, role) VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');
INSERT INTO users (id, age, email, first_name, last_name, password) VALUES (1, 55, 'admin@gmail.com', 'admin', 'admin','$2a$12$s/1YhCeZxXmj4QNHP7A3wO27EnDMZUr00u8YH/wk8zGGIekc172DC
');
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
