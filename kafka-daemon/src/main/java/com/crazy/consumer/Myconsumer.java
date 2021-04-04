package com.crazy.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.*;

public class Myconsumer {
    public static void main(String[] args) {
        //创建消费者配置信息
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop101:9092");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);//自动提交
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");//自动提交延迟
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        //给配置信息赋值
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"");
        //创建消费者组
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"bigdata2");
        //创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        //订阅主题
        consumer.subscribe(Arrays.asList("first","second"));
        //获取数据
        while (true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            //解析并打印console
            for(ConsumerRecord<String,String> consumerRecord:consumerRecords){
                System.out.println(consumerRecord.key()+"--"+consumerRecord.value());
            }
//            consumer.commitAsync();
            consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                    if(e != null){
                        System.out.println("commit failed for " + map);
                    }
                }
            });
        }




        //关闭连接
//        consumer.close();
    }
}
