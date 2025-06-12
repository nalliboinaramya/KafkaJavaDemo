package com.ikea.kafkademoproject.customserializer;

import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

public class SupplierDeserializer implements Deserializer<Supplier>{
	
	  @Override

      public void configure(Map<String, ?> configs, boolean isKey) {

                     // TODO Auto-generated method stub

                    

      }



      @Override

      public Supplier deserialize(String topic, byte[] data) {

                     try {

                                   if(data==null)    {

                                                  System.out.println("Null cannnot be deserialized");

                                        return null;

                         }

                                   ByteBuffer buf=ByteBuffer.wrap(data);

                                   int id=buf.getInt();

                                  

                                   int sizeOfName=buf.getInt();

                                   byte[] nameBytes=new byte[sizeOfName];

                                   buf.get(nameBytes);

                                   String deserializedName=new String(nameBytes);

                                  

                                   int sizeOfDate=buf.getInt();

                                   byte[] dateBytes=new byte[sizeOfDate];

                                   buf.get(dateBytes);

                                   String deserializedDate=new String(dateBytes);

                                   DateFormat df=new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");

                                  

                                   return new Supplier(id,deserializedName,df.parse(deserializedDate));

                     }catch(Exception e) {

                    	 System.out.println(e.toString());
                    	 return null;

                     }

      }



      @Override

      public void close() {

                     // TODO Auto-generated method stub

                    

      }

/*

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Supplier deserialize(String topic, byte[] data) {
		try {
			if(data == null) {
				System.out.println("null cannot be deserialized");
				return null;
			}
			
			ByteBuffer buf = ByteBuffer.wrap(data);
			int id = buf.getInt();
			int sizeOfName = buf.getInt();
			byte[] nameBytes = new byte[sizeOfName];
			buf.get(nameBytes);
			String deserializedName = new String(nameBytes);
			
			int sizeOfDate = buf.getInt();
			
			byte[] dateBytes = new byte[sizeOfDate];
			String deserializedDate = new String(dateBytes);
			
			buf.get(dateBytes);
			
			DateFormat df = new SimpleDateFormat("EEE MMM DD HH:mm:ss Z yyyy");
			return new Supplier(id,deserializedName,df.parse(deserializedDate));
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}*/

}
