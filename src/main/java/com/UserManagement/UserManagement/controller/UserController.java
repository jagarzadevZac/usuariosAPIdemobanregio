package com.UserManagement.UserManagement.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import com.UserManagement.UserManagement.dto.Mensaje;
import com.UserManagement.UserManagement.dto.UserDto;
import com.UserManagement.UserManagement.entity.User;
import com.UserManagement.UserManagement.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){

        List<User> list = userService.list();
        return new ResponseEntity<List<User>>(list , HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        if(!userService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no exist") , HttpStatus.NOT_FOUND);

        User user = userService.getOne(id).get();
        return new ResponseEntity<User>(user,OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDto, String string){
        if(StringUtils.isBlank(userDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("nombre es requerido"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(userDto.getBrm()))
            return new ResponseEntity<>(new Mensaje("brm es requerido"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(userDto.getPuesto()))
            return new ResponseEntity<>(new Mensaje("puesto es requerido"), HttpStatus.BAD_REQUEST);

        User user = new User(userDto.getBrm(), userDto.getFoto(), userDto.getNombre(),userDto.getPuesto());
        userService.save(user);

        return new ResponseEntity<>(new Mensaje("user create ok"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UserDto userDto){
        if(!userService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe el usuario"), HttpStatus.NOT_FOUND);

        if(StringUtils.isBlank(userDto.getNombre()))
            return new ResponseEntity<>(new Mensaje("nombre es requerido"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(userDto.getBrm()))
            return new ResponseEntity<>(new Mensaje("brm es requerido"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(userDto.getPuesto()))
            return new ResponseEntity<>(new Mensaje("puesto es requerido"), HttpStatus.BAD_REQUEST);
        
        User user = userService.getOne(id).get();
        user.setBrm(userDto.getBrm());
        user.setFoto(userDto.getFoto());
        user.setNombre(userDto.getNombre());
        user.setPuesto(userDto.getPuesto());
        userService.save(user);

        return new ResponseEntity<>(new Mensaje("user update ok"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!userService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no exist"), HttpStatus.NOT_FOUND);

        userService.delete(id);
        return new ResponseEntity<>(new Mensaje("user delete ok"), HttpStatus.OK);

    }
    
}
