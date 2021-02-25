package com.crazy18.zookeeper100;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer server = new DistributeServer();
        //连接zk集群
        server.getConnect();
        //注册节点
        server.regist(args[0]);
        //业务逻辑处理
        server.business();
    }

    private void business() throws InterruptedException {

        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        zkClient.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + " is online");
    }

    private String connectString =
            "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    private int sessionTimeout = 200000;
    private ZooKeeper zkClient;
    private void getConnect() throws IOException {

        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }


}
