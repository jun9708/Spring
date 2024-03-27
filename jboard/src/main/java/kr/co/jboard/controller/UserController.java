package kr.co.jboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.jboard.dto.TermsDTO;
import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    //GetMapping User 부분
    private final UserService userService;

    @GetMapping("/user/login")
    public String login(){

        return "/user/login";
    }

    //약관동의 DB에서 MyBatis로 불러오기
    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO termsDTO = userService.selectTerms();
        model.addAttribute(termsDTO);

        return "/user/terms";
    }

    //회원가입
    @GetMapping("/user/register")
    public String register(){

        return "/user/register";
    }

    //회원가입시 사용자가 입력한 POST 요청 처리
    @PostMapping("/user/register")
    public String register(HttpServletRequest req, UserDTO userDTO){

        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        log.info(userDTO.toString());

        userService.insertUser(userDTO);

        return "redirect:/user/login?success=200";
    }






}
