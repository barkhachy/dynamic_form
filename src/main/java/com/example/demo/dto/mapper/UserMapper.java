package com.example.demo.dto.mapper;

import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.dto.model.UserDto;
import com.example.demo.model.User;

/**
 * Mapper function - UserDto to User and vice versa
 */
public class UserMapper {

    public static UserDto UserToUserDto(User user)
    {
        UserDto userDto = new UserDto(user.getId(), user.getName(), user.getE_mail());
        return userDto;
    }

    public static User UserDtoToUser(EditUserDto userDto)
    {
        User user = new User(null,userDto.getName(),userDto.getE_mail());
        return user;
    }
}
