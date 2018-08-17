package com.swjtu.test2;

import org.apache.zookeeper.KeeperException;

import java.util.List;

/**
 * 删除分组
 * @author leo
 *
 */
public class DeleteNode extends ConnectionManager {


    public void delete(String groupName) {
        String path = "/" + groupName;

        try {
            List<String> children = zk.getChildren(path, false);

            for(String child : children){
                zk.delete(path + "/" + child, -1);
            }
            zk.delete(path, -1);//版本号为-1，
        }
        catch (KeeperException e) {
            e.printStackTrace();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
