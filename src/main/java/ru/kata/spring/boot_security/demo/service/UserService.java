package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    public Set<User> allUsers();

    public User findById(Long id);

    public void addUser(User user);

    public void updateUser(User user);

    Optional<User> findByEmail(String username);

    public void removeUser(Long id);

    Set<Role> roleList();


}
