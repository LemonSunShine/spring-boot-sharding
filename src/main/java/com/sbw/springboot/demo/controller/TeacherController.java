package com.sbw.springboot.demo.controller;

import com.sbw.springboot.demo.jpa.entity.Teacher;
import com.sbw.springboot.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JPA 方式数据交互
 * Created by sbw on 2017/12/1.
 */
@RestController("jpa.teacherController")
@RequestMapping(value = "/data/jpa/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 查询用户列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getTeacherList(HttpServletRequest request) {
        List<Teacher> teacherList = this.teacherService.findAll();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("total", teacherList.size());
        param.put("rows", teacherList);
        return param;
    }

    /**
     * 查询用户信息
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public Teacher getTeacher(@PathVariable Long userId, HttpServletRequest request) {
        Teacher teacher = this.teacherService.findTeacher(userId);
        if (teacher == null) {
            throw new RuntimeException("查询错误");
        }
        return teacher;
    }
    
}
