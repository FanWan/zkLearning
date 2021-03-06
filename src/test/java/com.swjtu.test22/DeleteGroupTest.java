package com.swjtu.test22;

import com.swjtu.test2.DeleteGroup;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by wanfan01 on 2018/8/2.
 */
public class DeleteGroupTest {



    private static final String HOSTS = "127.0.0.1";
    private static final String groupName = "zoo";

    private DeleteGroup deleteGroup = null;

    @Before
    public void init() throws IOException, InterruptedException {
        deleteGroup = new DeleteGroup();
        deleteGroup.connection(HOSTS);
    }

    @Test
    public void testDelete() throws IOException, InterruptedException, KeeperException {
        deleteGroup.delete(groupName);
    }

    @After
    public void destroy() throws InterruptedException {
        if(null != deleteGroup){
            try {
                deleteGroup.close();
            } catch (InterruptedException e) {
                throw e;
            }finally{
                deleteGroup = null;
                System.gc();
            }
        }
    }
}
