package com.example.demo.dao;

import com.example.demo.pojo.Data;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface Mapper {
    @Select("select * from user")
    List<Data>  select();
}