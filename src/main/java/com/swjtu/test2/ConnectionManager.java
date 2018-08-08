package com.swjtu.test2;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wanfan01 on 2018/8/8.
 */
public abstract class ConnectionManager {

    private static final int SESSION_TIMEOUT = 1000;                //会话延时
    private CountDownLatch countDownLatch = new CountDownLatch(1);  //同步计数器
    protected ZooKeeper zk = null;

    /**
     * 创建zk对象
     * 当客户端连接上zookeeper时会执行process(event)里的countDownLatch.countDown()，计数器的值变为0，
     * 则countDownLatch.await()方法返回。
     * @param hosts
     * @throws IOException
     * @throws InterruptedException
     */
    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();//计数器减一
                    System.out.println("invoking");
                }
            }
        });
        countDownLatch.await();                 //阻塞程序继续执行
        System.out.println("invoked");
    }

    /**
     * 检查nodeName是否存在
     */
    public Stat exist(String nodeName) {
        Stat res = null;
        try{
            res = zk.exists("/" + nodeName, true);
        }
        catch (Exception e){
            System.out.println(e.toString());

        }
        return res;
    }

    /**
     * 关闭zk
     * @throws InterruptedException
     */
    public void close() throws InterruptedException {
        if(zk != null){
            try {
                zk.close();
            } catch (InterruptedException e) {
                throw e;
            }finally{
                zk = null;
                System.gc();
            }
        }
    }


}
