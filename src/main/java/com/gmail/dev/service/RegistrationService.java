package com.gmail.dev.service;

import com.gmail.dev.domain.User;
import com.gmail.dev.enums.City;
import com.gmail.dev.enums.Role;
import com.gmail.dev.enums.State;
import com.gmail.dev.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public void signUp(UserForm userForm) {
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .login(userForm.getLogin())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(Role.USER)
                .state(State.ACTIVE)
                .city(userForm.getCity())
                .build();

        if (City.USA.equals(userForm.getCity())) {
            user.setStateUSA(userForm.getStateUSA());
        } else if (City.CANADA.equals(userForm.getCity())) {
            user.setCityCanada(userForm.getCityCanada());
        }

        userService.save(user);
    }
}
