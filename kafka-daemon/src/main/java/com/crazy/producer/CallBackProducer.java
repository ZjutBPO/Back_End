package com.crazy.producer;

import org.apache.kafka.clients.producer.*;

import java.time.Period;
import java.util.ArrayList;
import java.util.Properties;

public class CallBackProducer {
    public static void main(String[] args) {
        //创建配置信息
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop101:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        //创建生产者对象
        KafkaProducer<String,String>producer = new KafkaProducer<String, String>(properties);

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        //发送数据
        for(int i =0 ;i < 10;i++){
            producer.send(new ProducerRecord<>("aa",list.get(i % 3),"jmh__" + i), (recordMetadata, e) -> {
                if(e == null)
                    System.out.println(recordMetadata.partition()+"--"+recordMetadata.offset());
                else{
                    e.printStackTrace();
                }
            });
        }

        //关闭资源
        producer.close();
    }
}
