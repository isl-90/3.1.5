package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class DatabaseInitializer {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DatabaseInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initDatabase() {
        // Добавление роли администратора
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);

        // Добавление роли пользователя
        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);

        // Создание администратора
        User adminUser = new User("admin", "Admin", "admin123", "admin@mail.ru", Collections.singleton(adminRole));
        userRepository.save(adminUser);

        // Создание обычного пользователя
        User regularUser = new User("user", "User", "user123", "user@mail.ru", Collections.singleton(userRole));
        userRepository.save(regularUser);
    }
}