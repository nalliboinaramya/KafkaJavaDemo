package com.ikea.kafkademoproject.customserializer;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

public class SupplierSerializer implements Serializer<Supplier> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public byte[] serialize(String topic, Supplier data) {
		try {
			if(data == null) {
				return null;
			}
			else {
			byte[] serializedName = data.getSupplierName().getBytes();
			int sizeOfName = serializedName.length;
			byte[] serializedDate = data.getDate().toString().getBytes();
			int sizeOfDate = serializedDate.length;
			ByteBuffer buf = ByteBuffer.allocate(1000);
			buf.putInt(data.getId());
			buf.putInt(sizeOfName);
			buf.put(serializedName);
			buf.putInt(sizeOfDate);
			buf.put(serializedDate);
			
			return buf.array();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}*/
	
	@Override
	public byte[] serialize(String topic, Supplier data) {
	    try {
	        if (data == null) {
	            return null;
	        }

	        byte[] serializedName = data.getSupplierName().getBytes();
	        int sizeOfName = serializedName.length;

	        byte[] serializedDate = data.getDate().toString().getBytes();
	        int sizeOfDate = serializedDate.length;

	        ByteBuffer buf = ByteBuffer.allocate(4 + 4 + sizeOfName + 4 + sizeOfDate); // id + name size + name + date size + date
	        buf.putInt(data.getId());
	        buf.putInt(sizeOfName);
	        buf.put(serializedName);
	        buf.putInt(sizeOfDate);
	        buf.put(serializedDate);

	        return buf.array();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


}
