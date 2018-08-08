package com.swjtu.test2;

import org.apache.zookeeper.*;

public class CreateNode extends ConnectionManager {

    /**
     * 创建node
     *
     * @param nodeName 节点名称
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void create(String nodeName, byte[] data) throws KeeperException, InterruptedException {
        if(null != exist(nodeName))
            return;
        String path = "/" + nodeName;

        //OPEN_ACL_UNSAFE--允许任何客户端对该znode进行读写, PERSISTENT--持久化的znode
        String createPath = zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("Created " + createPath);
    }





}
