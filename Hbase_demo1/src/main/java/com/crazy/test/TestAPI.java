package com.crazy.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

/*
* DDL
* 1、判断表是否存在
* 2、创建表
* 3、创建命名空间
* 4、删除表
*
* DML
* 5、插入数据
* 6、查数据（get)
* 7、查数据（scan）
* 8、删除数据
*
* */
public class TestAPI {
    private static Connection connection = null;
    private static Admin admin = null;
    static {

        try {
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum","192.168.1.101,192.168.1.102,192.168.1.103");
            connection = ConnectionFactory.createConnection(configuration);
            admin = connection.getAdmin();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //1、判断表是否存在


    public static boolean isTableExist(String tableName) throws IOException {

        //3、判断表是否存在
        boolean exists = admin.tableExists(TableName.valueOf(tableName));


        //4、关闭连接
//        admin.close();

        //5、返回结果
        return exists;
    }

    public static void close(){
        if(admin!=null){
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1、测试表是否存在
        System.out.println(isTableExist("stu"));
        //关闭资源
        close();
    }
}
