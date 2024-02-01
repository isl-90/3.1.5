CREATE TABLE IF NOT EXISTS roles(
                                    id SERIAL PRIMARY KEY,
                                    role VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS users(
                                    id SERIAL PRIMARY KEY,
                                    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INTEGER NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS user_roles(
                                         user_id INTEGER,
                                         role_id INTEGER,
                                         FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
    );
