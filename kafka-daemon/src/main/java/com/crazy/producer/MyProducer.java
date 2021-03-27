package com.crazy.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MyProducer {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建kafka生产者的配置信息
        Properties properties = new Properties();
        //连接指定的kafka集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop101:9092");
        //ack应答级别
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        //重试次数
        properties.put("retries",3);
        //批次大小
        properties.put("batch.size",16384);
        //等待时间
        properties.put("linger.ms",1);
        //RecordAccumulator缓冲区大小
        properties.put("buffer.memory",33554432);
        //kv序列化类
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //创建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for(int i = 0; i < 10; i++ ){
            producer.send(new ProducerRecord<String, String>("bigdata", "jmh_" + i)).get();
        }
        Thread.sleep(100);
        //关闭资源
//        producer.close();

    }
}
