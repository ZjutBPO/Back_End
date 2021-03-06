package com.crazy.test;

import javafx.scene.control.Tab;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.jute.compiler.JString;

import javax.ws.rs.DELETE;
import java.io.IOException;
import java.util.List;

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
    //2、创建表
    public static void createTable(String tableName,String... cfs) throws IOException {

        //1、判断是否存在列族信息
        if(cfs.length<=0){
            System.out.println("请设置列族信息");
            return;
        }
        //2、判断表是否存在
        if(isTableExist(tableName)){
            System.out.println(tableName+"表已存在");
            return;
        }
        //3、创建表描述器
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        //4、循环添加列族信息
        for(String cf : cfs){
            //5、创建列族描述器
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);

            //6、添加具体列族信息
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        //7、创建表
        admin.createTable(hTableDescriptor);

    }
    //3、删除表
    public static void dropTable(String tableName) throws IOException {

        //1、判断表是否存在
        if(!isTableExist(tableName)){
            System.out.println(tableName+"不存在");
            return;
        }
        //2、使表下线
        admin.disableTable(TableName.valueOf(tableName));

        //3、删除表
        admin.deleteTable(TableName.valueOf(tableName));

    }
    //4、创建命名空间

    public static void createNameSpace(String ns){
        //1、创建命名空间描述器
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(ns).build();
        //2、创建命名空间
        try {
            admin.createNamespace(namespaceDescriptor);
        }catch (NamespaceExistException ne){
            System.out.println(ns+" namespace already exist,create failed");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    //5、向表中插入数据
    public static void putData(String tableName, String rowKey, String cf, String cn, String value) throws IOException {
        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));

        //2、创建put对象
        Put put = new Put(Bytes.toBytes(rowKey));

        //3、给put赋值
        put.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn),Bytes.toBytes(value));

        //4、插入数据
        table.put(put);
        //5.关闭连接
        table.close();

        Admin admin = connection.getAdmin();

    }

    //6.获取数据（get)
    public static void getData(String tableName, String rowKey, String cf, String cn) throws IOException {
        //1.获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        //2.创建get对象
        Get get = new Get(Bytes.toBytes(rowKey));
        //2.1、获取指定列族
//        get.addFamily(Bytes.toBytes(cf));
        //2.2、获取指定列名
        get.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn));
        //2.3.获取数据版本数
        get.readAllVersions();
        //3.获取数据
        Result result =table.get(get);
        //4解析result
        for (Cell cell : result.rawCells()) {
            //5.打印数据
            System.out.println("CF " + Bytes.toString(CellUtil.cloneFamily(cell)) +
                    " CN " + Bytes.toString(CellUtil.cloneQualifier(cell)) +
                    " Value " + Bytes.toString(CellUtil.cloneValue(cell)) +
                    " row " + Bytes.toString(CellUtil.cloneRow(cell)) +
                    " ts " + cell.getTimestamp());
        }

        table.close();
    }

    //7、获取数据（scan）
    public static void scanTable(String tableName) throws IOException {
        //1、获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        //2.构建scan对象
        Scan scan = new Scan(Bytes.toBytes("1001"),Bytes.toBytes("1001"));
        //3.扫描表
        ResultScanner scanner = table.getScanner(scan);
        //4.解析resultscanner
        for (Result result : scanner) {
            for (Cell cell : result.rawCells()) {
                //5.打印数据
                System.out.println("CF " + Bytes.toString(CellUtil.cloneFamily(cell)) +
                        " CN " + Bytes.toString(CellUtil.cloneQualifier(cell)) +
                        " Value " + Bytes.toString(CellUtil.cloneValue(cell)) +
                        " row " + Bytes.toString(CellUtil.cloneRow(cell)) +
                        " ts " + cell.getTimestamp());
            }
        }
        table.close();
    }
    //8.删除数据
    public static void deleteData(String tableName, String rowKey, String cf, String cn) throws IOException {
        //1.获取表对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        //2.获取delete对象
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        //2.1设置删除的列
//        delete.addColumn(Bytes.toBytes(cf),Bytes.toBytes(cn),1615037220830L);
//        delete.addColumns(Bytes.toBytes(cf),Bytes.toBytes(cn));
        //2.2设置删除的列族
        delete.addFamily(Bytes.toBytes(cf));
        //3.执行删除操作
        table.delete(delete);

        //4.关闭连接
        table.close();

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
//        System.out.println("table exist"+isTableExist("stu"));
        //2、创建表测试
//        createTable("1818:stu5","info1","info2");
//        System.out.println("create success"+isTableExist("1818:stu5"));
        //3、删除表测试
//        dropTable("stu5");
//        System.out.println("after delete table"+isTableExist("stu5"));
        //4、创建命名空间测试
//        createNameSpace("1818");
//        System.out.println("create ns "+isTableExist("stu5"));
        //5、创建数据测试
//        putData("stu","1003","info1","name","jmh");
        //6.获取单行数据测试
//        getData("stu","1008","info1","name");
        //7.获取表数据测试（scan）
//        scanTable("stu1");
        //8、删除测试
        deleteData("stu","1009","info1","name");
        //关闭资源

        close();
    }
}
