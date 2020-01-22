/*purpose:it will used to serialize object
 * @author kishorereddy
 * @version 1.0
 * @since 21/1/2020
 * @file SerializeSingleTonTest.java
*/
package com.bridgelabz.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializedSingleTonTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		SerializedSingleTon instanceone = SerializedSingleTon.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
		out.writeObject(instanceone);
		out.close();
		//file t object
		ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
		SerializedSingleTon instancetwo = (SerializedSingleTon) in.readObject();
		in.close();
		
		System.out.println("instance one :"+instanceone.hashCode());
		System.out.println("instance two :"+instancetwo.hashCode());
	}

}
