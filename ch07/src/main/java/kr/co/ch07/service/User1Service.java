package kr.co.ch07.service;

import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.entity.User1;
import kr.co.ch07.repository.User1Repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class User1Service {

    // 생성자 주입
    private final User1Repository repository;


    public void insertUser1(User1DTO user1DTO){
        // DTO를 Entity로 변환
        User1 user1 = user1DTO.toEntity();

        // Entity 저장(데이터베이스 Insert)
        repository.save(user1);
    }

    public User1DTO selectUser1(String uid){

        /*
            Optional
             - null 체크 검증처리를 손쉽고 안전하게 처리하기 위한 클래스
             - Spring JPA find 결과 타입
        */
        // 조회
        Optional<User1> result = repository.findById(uid);
        User1 user1 = result.get(); // 값이 존재하면 반환 그렇지 않으면 NoSuchElementException 발생

        // Entity를 DTO로 변환 후 리턴
        return user1.toDTO();
    }

    public List<User1DTO> selectUser1s(){
        // 전체 조회
        List<User1> user1s = repository.findAll();

        // for(외부반복자)을 이용한 Entity 리스트를 DTO 리스트로 변환
        /*
        List<User1DTO> user1DTOs = new ArrayList<>();

        for(User1 user1 : user1s){
            user1DTOs.add(user1.toDTO());
        }
        */

        // 스트림(내부반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        List<User1DTO> user1DTOs = user1s.stream()
                                         .map(entity -> User1DTO.builder()
                                                .uid(entity.getUid())
                                                .name(entity.getName())
                                                .birth(entity.getBirth())
                                                .hp(entity.getHp())
                                                .age(entity.getAge())
                                                .build())
                                         .collect(Collectors.toList());

        return user1DTOs;
    }

    public void updateUser1(User1DTO user1DTO){

        // DTO를 Entity로 변환
        User1 user1 = user1DTO.toEntity();

        // Entity 수정(데이터베이스 Update)
        repository.save(user1);
    }

    public void deleteUser1(String uid){
        // Entity 삭제(데이터베이스 Delete)
        repository.deleteById(uid);
    }
}
