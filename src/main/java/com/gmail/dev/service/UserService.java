package com.gmail.dev.service;

import com.gmail.dev.domain.User;
import com.gmail.dev.forms.UserForm;
import com.gmail.dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findOneById(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void updateUser(UserForm userForm, User user) {
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        save(user);
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }
}
