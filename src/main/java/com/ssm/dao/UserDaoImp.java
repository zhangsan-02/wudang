package com.ssm.dao;

import com.ssm.domain.User;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

public class UserDaoImp implements UserDao {
    private  static JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    private static Jedis jedis;
    static {
        jedis = new Jedis();
        jedis.auth("123456");
        jedis.ping();
        Map<String,String> map = jedis.hgetAll("user:1");
        User user = new User();
        user.setAge(Integer.parseInt(map.get("age")));
        user.setName(map.get("name"));
        user.setSex(map.get("sex"));
        System.out.println(user);
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(),"127.0.0.1",6379);
        jedisPool.getResource();

    }
        public User getUserById(Integer id) {


        return null;
    }

    public static void main(String[] args) {

    }
}
