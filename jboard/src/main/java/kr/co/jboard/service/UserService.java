package kr.co.jboard.service;

import kr.co.jboard.dto.TermsDTO;
import kr.co.jboard.dto.UserDTO;
import kr.co.jboard.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public TermsDTO selectTerms(){
        return userMapper.selectTerms();
    }

    public void insertUser(UserDTO userDTO){

        //회원가입시 비밀번호 암호화
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        userMapper.insertUser(userDTO);

    }

}
