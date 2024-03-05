package kr.co.ch04.dao;

import kr.co.ch04.dto.User2DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User2Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser2(User2DTO user2DTO){
        String sql = "insert into `user2` values (?,?,?,?)";

        Object[] params = {
                user2DTO.getUid(),
                user2DTO.getName(),
                user2DTO.getBirth(),
                user2DTO.getAddr(),
        };

        jdbcTemplate.update(sql, params);
    }

    public User2DTO selectUser2(String uid){
        String sql = "select * from `user2` where `uid`=?";
        return jdbcTemplate.queryForObject(sql, new User2RowMapper(), uid);

    }

    public List<User2DTO> selectUser2s(){

        String sql = "select * from `user2`";
        return jdbcTemplate.query(sql, new User2RowMapper());

    }

    public void updateUser2(User2DTO user2DTO){
        String sql = "update `user2` set `name`=?, `birth`=?, `addr`=? where `uid`=?";

        Object[] params ={
                user2DTO.getName(),
                user2DTO.getBirth(),
                user2DTO.getAddr(),
                user2DTO.getUid()
        };

        jdbcTemplate.update(sql, params);
    }

    public void deleteUser2(String uid){
        String sql = "delete from `user2` where `uid`=?";
        jdbcTemplate.update(sql, uid);
    }

}
