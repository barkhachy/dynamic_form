package com.example.demo.Controller;


import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.dto.Responsedto;
import com.example.demo.dto.edit.EditUserDto;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * To get list of all users
     *
     * @return
     * @throws NoDataFoundException --> When no user exists
     */
    @GetMapping(value = "/all")
    public ResponseEntity<Responsedto> getAllUsers() throws NoDataFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "all users", userService.getAllUsers());
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To get detail of a user based on provided id
     * @param id
     * @return
     * @throws UserNotFoundException --> When user with given id not found
     */
    @GetMapping(value ="/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value="id") String id) throws UserNotFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "details of this user" + id, userService.getDetails(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);

    }

    /**
     * To create a new User
     * @param user
     * @return
     * @throws MethodArgumentNotValidException
     */
    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Responsedto> createUser(@Valid @RequestBody EditUserDto user) throws MethodArgumentNotValidException
    {
            Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "created new User", userService.createUser(user));
            return new ResponseEntity<>(ans, HttpStatus.OK);

    }

    /**
     * To update details of a user
     * @param user
     * @param id
     * @return
     * @throws UserNotFoundException --> When user is not found
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<?> updateUser(@RequestBody EditUserDto user, @PathVariable(value="id") String id) throws UserNotFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "update the user", userService.updateUser(user, id));
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    /**
     * To delete a user
     * @param id
     * @return
     * @throws UserNotFoundException --> When user is not found
     */
    @DeleteMapping(value="{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") String id) throws UserNotFoundException
    {
        Responsedto ans = new Responsedto(HttpStatus.OK.toString(), "deleted the User", userService.delete(id));
        return new ResponseEntity<>(ans, HttpStatus.OK);

    }
}
