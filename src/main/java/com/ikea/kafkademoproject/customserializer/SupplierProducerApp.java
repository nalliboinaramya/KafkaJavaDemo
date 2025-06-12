package com.ikea.kafkademoproject.customserializer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class SupplierProducerApp {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
	    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");

	    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

	    //prop.put("value.serializer", StringSerializer.class);

	   prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SupplierSerializer.class);

	   
	   
	   KafkaProducer<String,Supplier> producer=new KafkaProducer<>(prop);

	   DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
	   Supplier s1 = new Supplier(100,"Ramya",df.parse("2000-10-20"));
		Supplier s2 = new Supplier(200,"Rishitha",df.parse("2000-11-20"));
	

	   ProducerRecord<String,Supplier> record=new ProducerRecord<>("finaltopic",s1);
	   ProducerRecord<String,Supplier> record1=new ProducerRecord<>("finaltopic",s2);

	  
	   producer.send(record);
	   producer.send(record1);

	  

	   producer.close();

	  

	   System.out.println("Producer sent message successfully");
	}
}
