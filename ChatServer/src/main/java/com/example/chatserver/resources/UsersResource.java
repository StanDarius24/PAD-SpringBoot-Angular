package com.example.chatserver.resources;


import com.example.chatserver.pojo.User;
import com.example.chatserver.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<User> getAll()
    {
        return  usersRepository.findAll();
    }
}
