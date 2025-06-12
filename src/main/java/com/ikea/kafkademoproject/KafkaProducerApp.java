package com.ikea.kafkademoproject;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.*;
import org.apache.kafka.clients.Metadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerApp {
	public static void main(String[] args) throws Exception, ExecutionException {
	
	Properties prop = new Properties();
    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");

    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

    //prop.put("value.serializer", StringSerializer.class);

   prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
   prop.put(ProducerConfig.ACKS_CONFIG, "1");
   
   
   KafkaProducer<String,String> producer=new KafkaProducer<>(prop);

   

   ProducerRecord<String,String> record=new ProducerRecord<>("simpletopicdemo","hello world");
   ProducerRecord<String,String> record1=new ProducerRecord<>("simpletopicdemo","welcome to Ikea");

  RecordMetadata recordMetadata = producer.send(record).get();
  
  System.out.println("message send to partition no : "+ recordMetadata.partition());
   producer.send(record);
   producer.send(record1);

  

   producer.close();

  

   System.out.println("Producer sent message successfully");

	}

}
