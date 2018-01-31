package com.sbw.springboot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sbw.springboot.demo.domain.Student;
import com.sbw.springboot.demo.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mybatis 方式数据交互
 * Created by sbw on 2017/11/30.
 */
@RestController("mybatis.studentController")
@RequestMapping(value="/data/mybatis/student")
@MapperScan("com.sbw.springboot.demo.mapper")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /**
     * 查询用户列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> getStudentList(HttpServletRequest request) {
        List<Student> studentList = this.studentService.findStudentList();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("total", studentList.size());
        param.put("rows", studentList);
        return param;
    }
    /**
     * 查询用户信息
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable Long userId, HttpServletRequest request) {
        Student student = this.studentService.findStudent(userId);
        if(student == null){
            throw new RuntimeException("查询错误");
        }
        return student;
    }

    /**
     * 新增方法
     */
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("user_id");
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");

        try{
            this.studentService.add(realName, nickName);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }
    /**
     * 更新方法
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.PUT)
    public void update(@PathVariable Long userId, @RequestBody JSONObject jsonObject) {
        Student student = this.studentService.findStudent(userId);
        String realName = jsonObject.getString("real_name");
        String nickName = jsonObject.getString("nick_name");

        try{
            this.studentService.update(realName, nickName, student.getId());
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("更新错误");
        }
    }
    /**
     * 删除方法
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
        try{
            this.studentService.delete(userId);
        }catch(Exception e){
            throw new RuntimeException("删除错误");
        }
    }
}