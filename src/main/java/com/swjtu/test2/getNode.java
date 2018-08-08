package com.swjtu.test2;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;


/**
 * Created by wanfan01 on 2018/8/8.
 */
public class GetNode extends ConnectionManager {


    final CountDownLatch connectedSignal = new CountDownLatch(1);
    public byte[] res = null;

    public void getData(String nodeName) {
        if (null != exist(nodeName)) {
            try {
                res = zk.getData("/" + nodeName, new Watcher() {

                    public void process(WatchedEvent we) {
                        if (we.getType() == Event.EventType.None) {
                            switch (we.getState()) {
                                case Expired:
                                    connectedSignal.countDown();
                                    break;
                            }
                        }
                        else {
                            try {
                                res = zk.getData("/" + nodeName, false, null);
                                connectedSignal.countDown();
                                System.out.println("inside:  " + new String(res, "UTF-8"));
                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }, null);
                System.out.println("outside:  " + new String(res, "UTF-8"));
                connectedSignal.await();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
