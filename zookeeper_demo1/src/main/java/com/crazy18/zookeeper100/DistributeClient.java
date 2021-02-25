package com.crazy18.zookeeper100;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeClient {
    private String connectString =
            "hadoop101:2181,hadoop102:2181,hadoop103:2181";
    private int sessionTimeout = 200000;
    private ZooKeeper zkClient;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {


        DistributeClient client = new DistributeClient();
        //获取zk集群连接
        client.getConnect();
        //注册监听
        client.getChildren();
        //业务逻辑处理
        client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        zkClient.getChildren("/servers", true);

        List<String> children = zkClient.getChildren("/servers", true);
        ArrayList<String> hosts = new ArrayList<>();
        for (String child : children){
            byte[] data = zkClient.getData("/servers/" + child, false, null);

            hosts.add(new String(data));
        }

        //将所有在线主机打印到控制台
        System.out.println(hosts);
    }

    private void getConnect() throws IOException {


        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
