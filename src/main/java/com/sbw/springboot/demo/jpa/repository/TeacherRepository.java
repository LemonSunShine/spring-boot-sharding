package com.sbw.springboot.demo.jpa.repository;

import com.sbw.springboot.demo.jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 数据访问层，通过编写一个继承自 JpaRepository 的接口就能完成数据访问；
 * 也可以 调用 EntityManager 类方法去访问 数据库，但没有此方法简洁！
 * Created by sbw on 2017/12/1.
 */
public interface TeacherRepository extends JpaRepository<Teacher,Long>{

    List<Teacher> findAll();

    @Query("from Teacher where id = :id")
    Teacher findTeacher(@Param("id") Long id);

}
