package com.sbw.springboot.demo.mapper;

import com.sbw.springboot.demo.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 相当于Dao
 * Created by sbw on 2017/11/30.
 */
@Mapper
public interface StudentMapper {

    @Insert("insert into t_student(real_name, nick_name) values(#{real_name}, #{nick_name})")
    int add(@Param("real_name") String realName, @Param("nick_name") String nickName);

    @Update("update t_student set real_name = #{real_name}, nick_name = #{nick_name} where id = #{id}")
    int update(@Param("real_name") String realName, @Param("nick_name") String nickName, @Param("id") Long id);

    @Delete("delete from t_student where id = #{id}")
    int delete(Long id);

    @Select("select id, real_name as realName, nick_name as nickName from t_student where id = #{id}")
    Student findStudent(@Param("id") Long id);

    @Select("select id, real_name as realName, nick_name as nickName from t_student")
    List<Student> findStudentList();
}