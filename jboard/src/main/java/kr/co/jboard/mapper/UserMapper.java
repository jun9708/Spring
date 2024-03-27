package kr.co.jboard.mapper;

import kr.co.jboard.dto.TermsDTO;
import kr.co.jboard.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public TermsDTO selectTerms();
    public void insertUser(UserDTO userDTO);

}
