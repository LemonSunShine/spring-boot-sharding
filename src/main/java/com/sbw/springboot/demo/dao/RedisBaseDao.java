package com.sbw.springboot.demo.dao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis 底层交互
 * Created by Administrator on 2017/12/1.
 */
@Repository
public class RedisBaseDao {

    @Resource(name="redisTemplate")
    protected RedisTemplate redisTemplate;

    /**
     * 普通 key-value 形式
     * @param key
     * @param value
     */
    public void addValue(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据Key获取对象
     * @param key
     * @return
     */
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置 key-setValue 形式
     * @param key
     * @param value
     */
    public void addSetValue(String key, Set<Object> value){
        redisTemplate.opsForSet().add(key,value);
    }

    /**
     * 根据Key 获取 setValue
     * @param key
     * @return
     */
    public Set<Object> getSetValue(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 设置 key-mapValue 形式
     * @param key
     * @param value
     */
    public void addMapValue(String key,Map<Object,Object> value){
        redisTemplate.opsForHash().putAll(key,value);
    }

    /**
     * 根据 key 获取 mapValue
     * @param key
     * @return
     */
    public Map<Object,Object> getMapValue(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取 MapValue 的 values list
     * @param key
     * @return
     */
    public List<Object> getValueListOfMap(String key){
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * 获取 mapValue 的 key set
     * @param key
     * @return
     */
    public Set<Object> getKeySetOfMap(String key){
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 在mapValue根据 key 获取 value
     * @return
     */
    public Object getValueOfMapByKey(String key,Object map_Key){
        return redisTemplate.opsForHash().get(key,map_Key);
    }

    /**
     * 设置 key-ListValue形式
     * 默认左遍历
     * @param key
     * @param value
     */
    public void addListValue(String key,List<Object> value){
        redisTemplate.opsForList().leftPush(key,value);
    }

    /**
     * 获取 listValue
     * @param key
     * @return
     */
    public List<Object> getListValue(String key){
        return  (List<Object>)redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 不管是leftPush还是rightPush都可以用leftPop或者rightPoP任意一种获取到其中的值，
     * 不过就是获取的遍历方向不一样,遍历方向不同，所以效率也不同。
     * 所以最好leftPush用leftPoP遍历，rightPush用rightPoP遍历;
     * @param key
     * @param value
     */
    public void addRightListValue(String key,List<Object> value){
        redisTemplate.opsForList().rightPush(key,value);
    }

    public List<Object> getRightListValue(String key){
        return  (List<Object>)redisTemplate.opsForList().rightPop(key);
    }
}
