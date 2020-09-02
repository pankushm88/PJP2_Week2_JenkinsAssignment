package com.sapient.DateCalculator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class SessionStorage {

	public static void write(Date dt1) throws IOException, ClassNotFoundException {
		
		List<Date> DataList = new ArrayList<Date>();
		DataList = SessionStorage.read();
		
		DataList.add(dt1);
		if(DataList.size()>100) {
			DataList.remove(0);
			System.out.println("Trimming session storage to 100");
		}
	    FileOutputStream fileOutputStream = new FileOutputStream("E:\\pre-learning-program-2\\assignments\\Week 2 Assignments\\week2 Assignment\\Storage.ser");

	    try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
	        objectOutputStream.writeInt(DataList.size());
	        for(Date train: DataList) {
	            objectOutputStream.writeObject(train);
	        }
	    }
	}
	
	public static List<Date> read() throws IOException, ClassNotFoundException {
		
		List<Date> DataList = new ArrayList<Date>();
	    FileInputStream fileInputStream = new FileInputStream("E:\\pre-learning-program-2\\assignments\\Week 2 Assignments\\week2 Assignment\\Storage.ser");

	    try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
	         int trainCount = objectInputStream.readInt();
	         for (int i = 0; i < trainCount; i++) {
	            DataList.add((Date)objectInputStream.readObject()); 
	        }
	         System.out.println("Session storage Memory");
	         return DataList;
	    }
	}
}
