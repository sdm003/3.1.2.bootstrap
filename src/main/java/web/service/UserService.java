package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void updateUser(User car);
    void deleteUser(Long id);
}