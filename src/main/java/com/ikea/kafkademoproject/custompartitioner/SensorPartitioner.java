package com.ikea.kafkademoproject.custompartitioner;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.record.InvalidRecordException;
import org.apache.kafka.common.utils.Utils;

public class SensorPartitioner implements Partitioner{

    

    String sensorname;



    @Override

    public void configure(Map<String, ?> configs) {

                   sensorname=configs.get("sensor.name").toString();  //sensorA

    }



    @Override

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

                   List<PartitionInfo> partitions=cluster.partitionsForTopic(topic);

                   int numPartitions = partitions.size();  //10

                  

                   int partition;

                   int sp=(int) Math.abs(numPartitions * 0.3);  //3

                  

                   if(keyBytes==null || !(key instanceof String))

                                 throw new InvalidRecordException("All messages must have sensor name as key");

                  

                   if(((String)key).equals(sensorname)) {

                                 partition = Utils.toPositive(Utils.murmur2(valueBytes)) % sp;  //0,1,2

                   } else

                                 partition = Utils.toPositive(Utils.murmur2(keyBytes)) % (numPartitions - sp);  //3,4,5,6,7,8,9

   

                   System.out.println("Key = "+(String)key+" Partition = "+partition);

                   return partition;

    }



    @Override

    public void close() {

                   // TODO Auto-generated method stub

                  

    }

}