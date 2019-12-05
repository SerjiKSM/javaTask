package com.gmail.dev.transfer;

import com.gmail.dev.domain.User;
import com.gmail.dev.enums.City;
import com.gmail.dev.enums.Role;
import com.gmail.dev.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Role role;
    private State state;
    private City city;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .state(user.getState())
                .city(user.getCity())
                .build();
    }

    public static List<UserDto> listFrom(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();

        users.forEach(user -> {
            UserDto userDto = UserDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .role(user.getRole())
                    .state(user.getState())
                    .city(user.getCity())
                    .build();
            userDtoList.add(userDto);
        });

        return userDtoList;
    }
}
