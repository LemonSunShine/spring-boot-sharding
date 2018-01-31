package com.sbw.springboot.demo.service;

import com.sbw.springboot.demo.jpa.entity.Teacher;
import com.sbw.springboot.demo.jpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Jpa service
 * Created by sbw on 2017/12/1.
 */
@Service("jpa.teacherService")
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }
    public Teacher findTeacher(Long id){
        return this.teacherRepository.findTeacher(id);
    }

}
