package com.sbw.springboot.demo.service;

import com.sbw.springboot.demo.dao.impl.ValueRedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by Administrator on 2017/12/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Autowired
    ValueRedisUtils valueRedisUtils;

    @Test
    public void testAddObjValue(){
        String key = "key1";
        Object value = "String_value1";
        valueRedisUtils.addStringValue(key,value);
        Assert.assertEquals(value,valueRedisUtils.getObjValue(key));
    }

    @Autowired
    RedisTemplate redisTemplate;

    /*@Test
    public void testAddListValue(){

        List<String> list1=new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2=new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        redisTemplate.opsForList().leftPush("listkey1",list1);
        redisTemplate.opsForList().rightPush("listkey2",list2);
        List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("listkey1");
        List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("listkey2");
        System.out.println("resultList1:"+resultList1);
        System.out.println("resultList2:"+resultList2);

        String key = "list1";
        List<Object> value = new ArrayList<>();
        value.add(new String("list_value1"));
        value.add(new String("list_value2"));
        value.add(new String("list_value3"));
        value.add(new String("list_value4"));
        valueRedisUtils.addListValue(key,value);
        Assert.assertEquals(value,valueRedisUtils.getListValue(key));
    }*/

    @Test
    public void testAddMapValue(){
        String key = "map1";
        Map<Object,Object> value = new HashMap<>();
        value.put("key11","map_value11");
        value.put("key22","map_value22");
        value.put("key33","map_value33");
        valueRedisUtils.addMapValue(key,value);
        Assert.assertEquals(value,valueRedisUtils.getMapValue(key));
    }

    /*@Test
    public void testAddSetValue(){
        String key = "set1";
        Set<Object> value = new HashSet<>();
        value.add("set_value1");
        value.add("set_value2");
        value.add("set_value3");
        value.add("set_value4");
        valueRedisUtils.addSetValue(key,value);
        Assert.assertEquals(value,valueRedisUtils.getSetValue(key));
    }*/



}
