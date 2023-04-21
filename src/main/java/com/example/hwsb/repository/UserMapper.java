package com.example.hwsb.repository;

import com.example.hwsb.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAllusers();
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(String id);
}
