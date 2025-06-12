package com.ikea.kafkademoproject;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerApp {
	
	  public static void main(String[] args) {

          Properties prop=new Properties();

         prop.put("bootstrap.servers","localhost:9092");

          prop.put("key.deserializer", StringDeserializer.class);

          //prop.put("value.deserializer", StringDeserializer.class);

    prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

          prop.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1");

         prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");  //earliest/latest

         

          Consumer<String,String> consumer=new KafkaConsumer<>(prop);

          consumer.subscribe(Arrays.asList("simpletopicdemo"));

         

          while(true) {

                        ConsumerRecords<String,String> records=consumer.poll(100);

                        for(ConsumerRecord<String,String> record:records) {

                        System.out.println(record.value());

                        }

          }

}



}
