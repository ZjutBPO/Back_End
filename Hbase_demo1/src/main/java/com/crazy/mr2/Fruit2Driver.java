package com.crazy.mr2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Fruit2Driver implements Tool {


    //1.定义配置信息
    private Configuration configuration= null;
    @Override
    public int run(String[] args) throws Exception {
        //1.获取Job对象
        Job job = Job.getInstance(configuration);
        //2.设置主类路径
        job.setJarByClass(Fruit2Driver.class);
        //3.设置Mapper&输出KV类型
        TableMapReduceUtil.initTableMapperJob("fruit",
                new Scan(),
                Fruit2Mapper.class,
                ImmutableBytesWritable.class,
                Put.class,
                job);

        //4.设置Reduce&输出的表
        TableMapReduceUtil.initTableReducerJob("fruit2",
                Fruit2Reducer.class,
                job);
        //5.提交任务
        boolean result = job.waitForCompletion(true);

        return result?0:1;
    }

    @Override
    public void setConf(Configuration conf) {
        configuration = conf;
    }

    @Override
    public Configuration getConf() {
        return configuration;
    }

    public static void main(String[] args) {

        try {
            Configuration configuration = HBaseConfiguration.create();
//            Configuration configuration = new Configuration();
            ToolRunner.run(configuration,new Fruit2Driver(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
