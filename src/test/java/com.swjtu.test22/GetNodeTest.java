package com.swjtu.test22;


import com.swjtu.test2.GetNode;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/**
 * Created by wanfan01 on 2018/8/8.
 */
public class GetNodeTest {

    private static String hosts = "127.0.0.1";
    private static String nodeName = "zk_wanfan";

    private GetNode getNode = null;

    /**
     * init
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @Before
    public void init() throws KeeperException, InterruptedException, IOException {
        getNode = new GetNode();
        getNode.connect(hosts);
    }

    @Test
    public void testGetNode() throws KeeperException, InterruptedException {
        getNode.getData(nodeName);
    }

    /**
     * 销毁资源
     */
    @After
    public void destroy() {
        try {
            getNode.close();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }



}
