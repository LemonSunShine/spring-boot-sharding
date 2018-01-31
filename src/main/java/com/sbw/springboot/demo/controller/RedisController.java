package com.sbw.springboot.demo.controller;

import com.sbw.springboot.demo.dao.impl.ValueRedisUtils;
import com.sbw.springboot.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4.
 */
@RestController("redis.redisController")
@RequestMapping(value = "/data/redis")
public class RedisController {

    @Autowired
    ValueRedisUtils valueRedisUtils;

    /**
     * 查询对象
     */
    @RequestMapping(value="/object", method = RequestMethod.GET)
    public Object getRedisObjectValue(HttpServletRequest request) {
        return valueRedisUtils.getObjValue("key1");
    }

    /**
     * 查询list
     * @param request
     * @return
     */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public Object getRedisListValue(HttpServletRequest request) {
        return valueRedisUtils.getListValue("list1");
    }

    /**
     * 查询map
     * @param request
     * @return
     */
    @RequestMapping(value="/map", method = RequestMethod.GET)
    public Object getRedisMapValue(HttpServletRequest request) {
        return valueRedisUtils.getMapValue("map1");
    }

    /**
     * 查询set
     * @param request
     * @return
     */
    @RequestMapping(value="/set", method = RequestMethod.GET)
    public Object getRedisSetValue(HttpServletRequest request) {
        return valueRedisUtils.getSetValue("set1");
    }

}
