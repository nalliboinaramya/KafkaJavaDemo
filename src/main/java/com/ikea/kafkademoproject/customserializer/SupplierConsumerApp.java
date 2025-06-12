package com.ikea.kafkademoproject.customserializer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class SupplierConsumerApp {
	
	/*public static void main(String[] args) {

        Properties prop=new Properties();

       prop.put("bootstrap.servers","localhost:9092");

        prop.put("key.deserializer", StringDeserializer.class);

        //prop.put("value.deserializer", StringDeserializer.class);

  prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SupplierDeserializer.class);

        prop.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1");

       prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");  //earliest/latest

       

        Consumer<String,Supplier> consumer=new KafkaConsumer<>(prop);

        consumer.subscribe(Arrays.asList("customserializertopic"));

       

        while(true) {

            ConsumerRecords<String,Supplier> records=consumer.poll(1000);

            for(ConsumerRecord<String,Supplier> record:records) {

            System.out.println("Supplier id: "+record.value().getId()+" Supplier name: "+record.value().getSupplierName()+" Supplier Start date: "+record.value().getDate());

        }
        }

}*/
	
	public static void main(String[] args) {

        Properties prop=new Properties();

       prop.put("bootstrap.servers","localhost:9092");

        prop.put("key.deserializer", StringDeserializer.class);

        //prop.put("value.deserializer", StringDeserializer.class);

  prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SupplierDeserializer.class);

        prop.put(ConsumerConfig.GROUP_ID_CONFIG, "grp2");

       prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");  //earliest/latest

       

        Consumer<String,Supplier> consumer=new KafkaConsumer<>(prop);

        consumer.subscribe(Arrays.asList("finaltopic"));

       

        while(true) {

                      ConsumerRecords<String,Supplier> records=consumer.poll(100);

                      for(ConsumerRecord<String,Supplier> record:records) {
                    	  	
                    	  System.out.println(" Supplier name: "+record.value().getSupplierName()+" Supplier Start date: "+record.value().getDate());
                      

                      }

        }

}



}
