package com.luliu.rest.controller.jdbc;

import com.luliu.rest.model.User;
import com.luliu.rest.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luliu3 on 2016/7/30.
 */
@RestController(value = "JdbcController")
@RequestMapping("/jdbc/user")
public class UserController {

    @Resource(name = "JdbcUserService")
    private IUserService userService;

    @GetMapping
    public ResponseEntity getAllUsers() {

        HttpHeaders headers = new HttpHeaders();
        List list = userService.getAll();
        if (null == list) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        headers.set("Number of Records Found", String.valueOf(list.size()));
        return new ResponseEntity<List>(list, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {

        HttpHeaders headers = new HttpHeaders();
        User u = userService.getById(id);
        if (null == u) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        headers.set("Record Found", u.getFirstname() + " " + u.getLastname());
        return new ResponseEntity<User>(u, headers, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity addUser(@RequestBody User user) {

        HttpHeaders headers = new HttpHeaders();
        if (null == user){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        } else if (userService.getById(user.getId()) != null) {
            headers.set("Record Conflict", "User with ID " + user.getId() + " already exists.");
            return new ResponseEntity<User>(headers, HttpStatus.CONFLICT);
        }
        userService.add(user);
        headers.set("Record Created", user.getFirstname() + " " + user.getLastname());
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        User user = userService.getById(id);
        if (null == user){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        int cnt = userService.deleteById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Record Deleted", user.getFirstname() + " " + user.getLastname());
        return new ResponseEntity<User>(user, headers, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {

        User isExist = userService.getById(id);
        if (null == isExist) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else if (null == user) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        userService.update(user);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Record Updated", user.getFirstname() + " " + user.getLastname());
        return new ResponseEntity<User>(user, headers, HttpStatus.OK);
    }

}
