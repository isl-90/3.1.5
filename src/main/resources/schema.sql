CREATE TABLE IF NOT EXISTS roles
(
    id   SERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    age        INT          NOT NULL,
    email      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles(id, role)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');
INSERT INTO users(id, age, email, first_name, last_name, password)
VALUES (1, 55, 'admin@gmail.com', 'admin', 'admin', '$2a$12$P10g/Tq0i/M7CfWW.Na47O/C.3kVTM1KtIST87z3Dm3ghM5tmfxV2
');
INSERT INTO user_roles(user_id, role_id)
VALUES (1, 2);
