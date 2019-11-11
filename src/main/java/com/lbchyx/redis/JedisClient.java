package com.lbchyx.redis;

import com.lbchyx.redis.domain.HashTypeObject;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisClient {
    Jedis jedis = null;
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        //判断key是否存在
        Boolean myKey = jedis.exists("myKey");
        //切换db
        jedis.select(9);
        //在切换的db中，设置key为value
        jedis.set("key1","value1");
        System.out.println("key1's vlaue : " + jedis.get("key1"));

        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(jedis.ttl("mykey"));


        HashTypeObject hashTypeObject = new HashTypeObject();
        hashTypeObject.setAge("" + 27);
        hashTypeObject.setId("" + 3);
        hashTypeObject.setName("fuck u");

        Class<? extends HashTypeObject> clazz = hashTypeObject.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            Method m = (Method) hashTypeObject.getClass().getMethod("get" + getMethodName(field.getName()));
            String val = (String) m.invoke(hashTypeObject);// 调用getter方法获取属性值
            jedis.hset("hashObjKey", field.getName(), val);
            System.out.println(field.getName());
        }

        Map<String, String> hashObjKey = jedis.hgetAll("hashObjKey");


    }

    // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName){
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    @Before
    public void setUp(){
        jedis = new Jedis("localhost");

    }


    @Test
    public void testKeyType(){

        String key = "key1";
        String type = jedis.type(key);
        System.out.println(type);
    }

    @Test
    public void listTest(){
        Long lpush = jedis.lpush("list1", "value1", "value2", "value3");
        jedis.rpush("list1","value4");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        System.out.println(list1);

    }


}
