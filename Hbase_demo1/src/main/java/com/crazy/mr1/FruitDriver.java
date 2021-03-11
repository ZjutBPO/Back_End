package com.crazy.mr1;


import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class FruitDriver implements Tool {

    //定义一个configuration
    private Configuration configuration = null;

    @Override
    public int run(String[] args) throws Exception {
        //1.获取job对象

        Job job = Job.getInstance(configuration);
        //2.设置驱动类路径
        job.setJarByClass(FruitDriver.class);
        //3.设置Mapper&Mapper输出的KV类型
        job.setMapperClass(FruitMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);
        //4.设置Reducer类
        org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil.initTableReducerJob(args[1],FruitReducer.class,job);

        //5.设置输入输出参数
        org.apache.hadoop.mapreduce.lib.input.FileInputFormat.setInputPaths(job,new Path(args[0]));
        //6.提交任务
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
            Configuration configuration = new Configuration();
            int run = ToolRunner.run(configuration, new FruitDriver(), args);
            System.exit(run);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
