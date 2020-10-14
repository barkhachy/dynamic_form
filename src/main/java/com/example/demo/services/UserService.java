package com.example.demo.services;

import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.dto.mapper.UserMapper;
import com.example.demo.dto.model.UserDto;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for User
 */
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    /**
     * To get list of all users
     * @return
     */
    public List<UserDto> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserMapper.UserToUserDto(user))
                .collect(Collectors.toList());
    }

    /**
     * To view details of particular user
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public UserDto getDetails(String id) throws UserNotFoundException
    {
        User user = userRepository.findByid(id);
        System.out.println(user);
        if(user == null)
        {
            throw new UserNotFoundException(id);
        }
        return UserMapper.UserToUserDto(user);
    }

    /**
     * To create a new user
     * @param user
     * @return
     */
    public UserDto createUser(EditUserDto user)
    {
        return UserMapper.UserToUserDto((userRepository.save(UserMapper.UserDtoToUser(user))));

    }

    /**
     * To update details of a User
     * @param user
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    public UserDto updateUser(EditUserDto user, String id) throws UserNotFoundException
    {
        User user1 = userRepository.findByid(id);
        if(user1 == null)
        {
            throw new UserNotFoundException(id);
        }
        User edit_user = UserMapper.UserDtoToUser(user);
        if(edit_user.getName() != null){
            user1.setName(edit_user.getName());
        }
        if(edit_user.getE_mail() != null)
        {
            user1.setE_mail(edit_user.getE_mail());
        }
        return UserMapper.UserToUserDto(userRepository.save(user1));
    }

    /**
     * To delete record of a user of provided id
     * @param id
     * @throws UserNotFoundException
     */
    public String delete(String id) throws UserNotFoundException
    {
        User user1 = userRepository.findByid(id);
        if(user1 == null)
        {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "";
    }
}
