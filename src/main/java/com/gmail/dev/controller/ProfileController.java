package com.gmail.dev.controller;

import com.gmail.dev.domain.User;
import com.gmail.dev.exeption.UserException;
import com.gmail.dev.forms.UserForm;
import com.gmail.dev.security.details.UserDetailsImpl;
import com.gmail.dev.service.UserService;
import com.gmail.dev.transfer.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import static com.gmail.dev.transfer.UserDto.from;
import static com.gmail.dev.transfer.UserDto.listFrom;

@Controller
public class ProfileController {
    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getProfile(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());

        model.addAttribute("userDatas", user);

        return "profile";
    }

    @GetMapping("/listUsers")
    public String getUsers(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        List<User> userList = userService.findAllUsers();
        List<UserDto> userDtoList = listFrom(userList);
        model.addAttribute("userDatas", userDtoList);

        return "profile";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(ModelMap model, Authentication authentication,
                             @RequestParam("id") Long id) {
        if (authentication == null) {
            return "redirect:/login";
        }

        if (id == null) {
            throw new UserException("Not found user id!");
        }

        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            userService.deleteUser(user.get());
        } else {
            throw new UserException("User not found with id " + id);
        }

        List<User> userList = userService.findAllUsers();
        List<UserDto> userDtoList = listFrom(userList);

        model.addAttribute("userDatas", userDtoList);

        return "profile";
    }

    @GetMapping("/editUser")
    public String editUser(ModelMap model, Authentication authentication,
                             @RequestParam("id") Long id) {
        if (authentication == null) {
            return "redirect:/login";
        }

        if (id == null) {
            throw new UserException("Not found user id!");
        }

        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            UserDto user = from(userOptional.get());
            model.addAttribute("userDatas", user);
            return "edit";
        } else {
            throw new UserException("User not found with id " + id);
        }
    }

    @PostMapping("/editUser")
    public String editUser(UserForm userForm, Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:/login";
        }

        if (userForm.getId() == null
                || userForm.getFirstName().isEmpty()
                || userForm.getLastName().isEmpty()) {
            throw new UserException("Fill data about user!");
        }

        Optional<User> userOptional = userService.findById(userForm.getId());
        if (userOptional.isPresent()) {
            userService.updateUser(userForm, userOptional.get());
        } else {
            throw new UserException("User not found with id " + userForm.getId());
        }

        List<User> userList = userService.findAllUsers();
        List<UserDto> userDtoList = listFrom(userList);
        model.addAttribute("userDatas", userDtoList);

        return "profile";
    }}