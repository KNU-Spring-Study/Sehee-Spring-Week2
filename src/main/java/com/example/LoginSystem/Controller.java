package com.example.LoginSystem;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("user")
public class Controller {

    Map<String, User> userList = new HashMap<>();

    @PostMapping("/login")
    public User loginPost(@RequestBody LoginDTO loginDTO) {
        if (userList.get(loginDTO.getUserId()) == null) {
            return new User();
        } else if (userList.get(loginDTO.getUserId()).getUserPassword().equals(loginDTO.getUserPassword())) {
            // 로그인 성공
            return userList.get(loginDTO.getUserId());
        }

        return null;
    }

    @PostMapping("/join")
    public String joinPost(@RequestBody User user) {
        // 하나라도 비어있는 경우
        if (user.getUserId().equals("") || user.getUserPassword().equals("") || user.getUserName().equals("") || user.getUserEmail().equals("")) {
            return "회원가입 실패";
        } else {
//            userList.add(user);
            userList.put(user.getUserId(), user);
            return "회원가입 성공";
        }
    }

    @GetMapping("/list")
    public List<User> userListGet() {
        List<User> users = new ArrayList<>(userList.values());
        return users;
    }

    @DeleteMapping("/joinout")
    public String joinoutDelete(@RequestBody LoginDTO loginDTO) {
        userList.remove(loginDTO.getUserId());
        return "회원탈퇴 성공";
    }
}
