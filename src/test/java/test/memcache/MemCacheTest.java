package test.memcache;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/*
 1)      memcached client for java
 较早推出的memcached JAVA客户端API，应用广泛，运行比较稳定。

 2)      spymemcached
 A simple, asynchronous, single-threaded memcached client written in java. 
 支持异步，单线程的memcached客户端，用到了java1.5版本的concurrent和nio，存取速度会高于前者，
 但是稳定性不好，测试中常 报timeOut等相关异常。

 3)      xmemcached
 XMemcached同样是基于java nio的客户端，java nio相比于传统阻塞io模型来说，有效率高（特别在高并发下）
 和资源耗费相对较少的优点。传统阻塞IO为了提高效率，需要创建一定数量的连接形成连接 池，而nio仅需要一个连接即可
 （当然,nio也是可以做池化处理），相对来说减少了线程创建和切换的开销，这一点在高并发下特别明显。因此 XMemcached
 与Spymemcached在性能都非常优秀，在某些方面（存储的数据比较小的情况下）Xmemcached比 Spymemcached的表现
 更为优秀，具体可以看这个Java Memcached Clients Benchmark。
 */
public class MemCacheTest {

	public static void main(String[] args) {
		/**
		 * 初始化SockIOPool，管理memcached的连接池
		 * */
		String[] servers = { "127.0.0.1:11211" };
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(servers);
		pool.setFailover(true);
		pool.setInitConn(10);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setAliveCheck(true);
		pool.initialize();
		/**
		 * 建立MemcachedClient实例
		 * */
		MemCachedClient memCachedClient = new MemCachedClient();
		for (int i = 0; i < 1000; i++) {
			/**
			 * 将对象加入到memcached缓存
			 * */
			boolean success = memCachedClient.set("" + i, "Hello!");
			/**
			 * 从memcached缓存中按key值取对象
			 * */
			String result = (String) memCachedClient.get("" + i);
			System.out.println(String.format("set( %d ): %s", i, success));
			System.out.println(String.format("get( %d ): %s", i, result));
		}
	}
}