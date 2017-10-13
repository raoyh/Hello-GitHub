import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.Iterator;
import java.util.Set;


public class RedisTest {
    @Test
    public  void aaa()     {
        int i = 1 ;
        int j = i++ ;
        if((i==(++j))&&((i++)==j))     {
            i += j ;
        }
        System.out.println("i = "+i);
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.10.117",6379);
        jedis.hset("userName","user","JAVA好");
        String s = jedis.hget("userName","user");
       // System.out.println(s);

    }
    @Test
    public  void  redisTest(){
        //设置连接池对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(50);
        //空闲时保存的最大连接数
        jedisPoolConfig.setMaxIdle(10);
        //创建连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"192.168.10.117",6379);
        //从池对象中获取链接对象
        Jedis jedis = jedisPool.getResource();
        //做你想做的事
        String s = jedis.hget("userName","user");
        System.out.println(s);
        //用完以后归还池对象到池中
        jedis.close();
    }
    @Test
    public  void redisTest1(){
        Jedis jedis = jedisUtil.getJedis();
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
        jedis.close();
    }
}
