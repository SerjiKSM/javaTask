package com.gmail.dev.controller;

import com.gmail.dev.domain.User;
import com.gmail.dev.exeption.UserException;
import com.gmail.dev.forms.UserForm;
import com.gmail.dev.service.CityCanadaService;
import com.gmail.dev.service.RegistrationService;
import com.gmail.dev.service.StateUSAService;
import com.gmail.dev.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;
    private StateUSAService stateUSAService;
    private CityCanadaService cityCanadaService;
    private UserService userService;

    public RegistrationController(RegistrationService registrationService,
                                  StateUSAService stateUSAService,
                                  CityCanadaService cityCanadaService,
                                  UserService userService) {
        this.registrationService =  registrationService;
        this.stateUSAService = stateUSAService;
        this.cityCanadaService = cityCanadaService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(ModelMap model) {
        model.addAttribute("statesUSA", stateUSAService.findAllStateUSA());
        model.addAttribute("citiesCanada", cityCanadaService.findAllCityCanada());
        return "registration";
    }

    @PostMapping("/registration")
    public String signUp(UserForm userForm) {

        if (userForm.getFirstName().isEmpty()
                || userForm.getLastName().isEmpty()
                || userForm.getLogin().isEmpty()
                || userForm.getPassword().isEmpty()) {
            throw new UserException("Fill data about user!");
        }

        Optional<User> userData = userService.findByLogin(userForm.getLogin());
        if (userData.isPresent())
            throw new UserException("User with such login present!");

        registrationService.signUp(userForm);
        return "redirect:/login";
    }

}
