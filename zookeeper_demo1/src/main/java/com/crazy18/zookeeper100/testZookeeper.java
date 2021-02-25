package com.crazy18.zookeeper100;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class testZookeeper {
    private static String connectString =
            "hadoop101:2181,hadoop102:2181,hadoop103:2181";

    private int sessionTimeout = 10000;//设置超时时间
    private ZooKeeper zkClient;
    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

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
        List<String> children = zkClient.getChildren("/",false);
        for(String child : children){
            System.out.println(child);
        }
    }
}
