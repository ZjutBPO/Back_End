package com.crazy18.zookeeper100;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class testZookeeper {
    private static String connectString =
            "hadoop101:2181,hadoop102:2181,hadoop103:2181";

    private int sessionTimeout = 100000;//设置超时时间
    private ZooKeeper zkClient;
    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/",true);
                    for(String child : children){
                        System.out.println(child);
                    }
                    System.out.println("------------------");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //创建节点
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkClient.create("/testNode", "jmhnice".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }
    //获取子节点并监控节点变化
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/",true);
        for(String child : children){
            System.out.println(child);
        }

        Thread.sleep(Long.MAX_VALUE);
    }
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkClient.exists("/testNode",false);
        System.out.println(stat == null ? "not" : "exist");
    }

}
