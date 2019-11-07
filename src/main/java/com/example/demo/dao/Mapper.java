package com.example.demo.dao;

        import com.example.demo.pojo.Blog;
        import com.example.demo.pojo.Data;
        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Select;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface Mapper {
    @Select("select * from user ")
    List<Blog>  select();

    @Insert("insert into user(title,text,tag,date,description) value(#{title},#{text},#{tag},#{date},#{description})")
    void insert(Blog blog);

    @Select("select count(*) from user")
    int count();

    @Select("select * from user ORDER BY id DESC limit #{firstPage},#{pageNumber}")
    List<Blog> limit_blog(int firstPage, int pageNumber);

    @Select("select * from user where id=#{id}")
    Blog findbyId(@Param(value = "id") int id);
}
