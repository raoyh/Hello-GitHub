import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class jedisUtil {

    private static final JedisPool JEDIS_POOL;
    static {
        //设置连接池对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(50);
        //空闲时保存的最大连接数
        jedisPoolConfig.setMaxIdle(10);
        //创建连接池对象
        JEDIS_POOL = new JedisPool(jedisPoolConfig,"192.168.10.117",6379);
    }
    /**
     * 从池中获取连接
     */
    public static Jedis getJedis(){
        return JEDIS_POOL.getResource();
    }
}
