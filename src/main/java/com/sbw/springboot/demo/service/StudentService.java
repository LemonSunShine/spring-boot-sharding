package com.sbw.springboot.demo.service;

import com.sbw.springboot.demo.domain.Student;
import com.sbw.springboot.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sbw on 2017/11/30.
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int add(String realName, String nickName) {
        return this.studentMapper.add(realName, nickName);
    }
    public int update(String realName, String nickName, Long id) {
        return this.studentMapper.update(realName, nickName, id);
    }
    public int delete(Long id) {
        return this.studentMapper.delete(id);
    }
    public Student findStudent(Long id) {
        return this.studentMapper.findStudent(id);
    }
    public List<Student> findStudentList() {
        return this.studentMapper.findStudentList();
    }
}