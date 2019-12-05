package com.gmail.dev.forms;

import com.gmail.dev.domain.CityCanada;
import com.gmail.dev.domain.StateUSA;
import com.gmail.dev.enums.City;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserForm {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private City city;
    private StateUSA stateUSA;
    private CityCanada cityCanada;
}
