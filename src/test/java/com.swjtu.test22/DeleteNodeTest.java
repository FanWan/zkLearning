package com.swjtu.test22;

import com.swjtu.test2.DeleteNode;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by wanfan01 on 2018/8/2.
 */
public class DeleteNodeTest {



    private static final String HOSTS = "127.0.0.1";
    private static final String groupName = "zk_wanfan";

    private DeleteNode deleteGroup = null;

    @Before
    public void init() throws IOException, InterruptedException {
        deleteGroup = new DeleteNode();
        deleteGroup.connect(HOSTS);
    }

    @Test
    public void testDelete() throws IOException, InterruptedException, KeeperException {
        deleteGroup.delete(groupName);
    }

    @After
    public void destroy() throws InterruptedException {
        try {
            deleteGroup.close();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
