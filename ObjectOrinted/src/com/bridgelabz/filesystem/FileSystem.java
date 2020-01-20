/*purpose:FileSystem is used to read and write the data into file
 * @author kishorereddy
 * @version 1.0
 * @since 20/01/2020
 * @file FileSystem.java
 */
package com.bridgelabz.filesystem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileSystem {
	
	/*
	 * function to implement readFile
	 */
	public JSONObject readFile(String file) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(file);
		Object object = parser.parse(reader);
		JSONObject json = (JSONObject) object;
		return json;
	}
	/*
	 * function to implement writeFile
	 */
	public void writeFile(String file, JSONObject object) throws IOException {
		FileWriter filewriter = new FileWriter(file);
		filewriter.write(object.toJSONString());
		filewriter.close();
	}

}
