package kr.co.jboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/user/login")
    public String login(){

        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){

        return "/user/register";
    }

    @GetMapping("/user/terms")
    public String terms(){

        return "/user/terms";
    }

    //GetMapping User 부분


}
