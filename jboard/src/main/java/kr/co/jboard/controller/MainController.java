package kr.co.jboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping(value={"/", "/index"})
    /*
        index 페이지에 대한 Get요청 메서드
        - value 속성으로 요청을 처리할때 URL 패턴을 지정

     */

    public String index(Authentication authentication){ //Authentication 스프링 시큐리티에서 제공하는 인증객체

        return "login";
    }

}
