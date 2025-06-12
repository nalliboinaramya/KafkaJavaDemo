package com.ikea.kafkademoproject.custompartitioner;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class SensorProducer {

	public static void main(String[] args) {

        Properties prop=new Properties();

       prop.put("bootstrap.servers","localhost:9092");

        prop.put("key.serializer", StringSerializer.class);

        //prop.put("value.serializer", StringSerializer.class);

       prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

       prop.put("partitioner.class", "com.ikea.kafkademoproject.custompartitioner.SensorPartitioner");
        prop.put("sensor.name", "sensorA");  //userdefined property

       

        KafkaProducer<String,String> producer=new KafkaProducer<>(prop);

       

        for(int i=0;i<10;i++)

                      producer.send(new ProducerRecord<String,String>("sensortopicdemo","sensorB"+i,"500"+i));



        for(int i=0;i<10;i++)

                      producer.send(new ProducerRecord<String,String>("sensortopicdemo","sensorA","500"+i));



        System.out.println("SensorProducer completed");

        producer.close();

}
}
