
package com.swjtu.test22;
import com.swjtu.test2.CreateNode;
import com.swjtu.test2.Data;
import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;



/**
 * Created by wanfan01 on 2018/8/2.
 */
public class CreateNodeTest {

    private static String hosts = "127.0.0.1";
    private static String nodeName = "zk_wanfan";

    private CreateNode createNode = null;

    /**
     * init
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @Before
    public void init() throws KeeperException, InterruptedException, IOException {
        createNode = new CreateNode();
        createNode.connect(hosts);
    }

    @Test
    public void testCreateGroup() throws KeeperException, InterruptedException {
        byte[] data = new Data("wan", "fan").objectToByteArray();
        createNode.create(nodeName, data);
    }

    /**
     * 销毁资源
     */
    @After
    public void destroy() {
        try {
            createNode.close();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }


}



