package web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class Main {


    @Autowired
    UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
