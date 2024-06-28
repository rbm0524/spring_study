package spring_basic.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_basic.hellospring.domain.User;
import spring_basic.hellospring.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService() {

    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean login(String id, String password) {
        return userRepository.login(id, password);
    }

    public boolean addUser(String id, String password) {
        return userRepository.addUser(id, password);
    }
}
