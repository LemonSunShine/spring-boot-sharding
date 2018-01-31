package com.sbw.springboot.demo.dao.impl;

import com.sbw.springboot.demo.dao.RedisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis工具类
 * Created by Administrator on 2017/12/4.
 */
@Repository
public class ValueRedisUtils {

    @Autowired
    public RedisBaseDao redisBaseDao;

    private static Set<String> keys = new HashSet<>();

    public void addStringValue(String key,Object value){
        redisBaseDao.addValue(key, value);
    }

    public void addSetValue(String key,Set<Object> value){
        redisBaseDao.addSetValue(key, value);
    }

    public void addMapValue(String key,Map<Object,Object> value){
        redisBaseDao.addMapValue(key, value);
    }

    public void addListValue(String key,List<Object> value){
        redisBaseDao.addListValue(key, value);
    }

    public Object getObjValue(String key){
        return redisBaseDao.getValue(key);
    }

    public Set<Object> getSetValue(String key){
        return redisBaseDao.getSetValue(key);
    }

    public Map<Object,Object> getMapValue(String key){
        return redisBaseDao.getMapValue(key);
    }

    public List<Object> getListValue(String key){
        return redisBaseDao.getListValue(key);
    }

}
