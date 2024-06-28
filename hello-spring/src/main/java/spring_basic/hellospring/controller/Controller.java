package spring_basic.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_basic.hellospring.domain.LoginRequest;
import spring_basic.hellospring.domain.User;
import spring_basic.hellospring.service.UserService;

@RestController
public class Controller {

    private UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String test() {
        return "First Controller";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String id = loginRequest.getId();
        String password = loginRequest.getPassword();

        if(userService.login(id, password)) {
            return "Login Success";
        } else {
            return "Login Failed";
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody LoginRequest signupRequest) {
        String id = signupRequest.getId();
        String password = signupRequest.getPassword();

        // 회원가입 로직 (예: 데이터베이스에 사용자 추가)
        if (userService.addUser(id, password)) {
            return "Signup successful";
        } else {
            return "Signup failed";
        }
    }

}
