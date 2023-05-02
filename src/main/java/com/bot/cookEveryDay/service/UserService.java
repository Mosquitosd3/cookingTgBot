package com.bot.cookEveryDay.service;

import com.bot.cookEveryDay.entity.User;
import com.bot.cookEveryDay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        Optional<User> rsl = repository.findById(user.getId());
        if (!rsl.isPresent()) {
            repository.save(user);
        }
    }

    public void save(long id, String firstName, String lastName, String username) {
        User user = new User(id, firstName, lastName, username);
        save(user);
    }

    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }
}
