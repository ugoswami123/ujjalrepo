package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataReader {
	 private Properties properties;
	 private final String propertyFilePath= "Data//config.properties";
	 
	 public DataReader(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
		 }
	 
	 public String getLocation(){
		 String location = properties.getProperty("location");
		 if(location!= null) return location;
		 else throw new RuntimeException("location not specified in the config.properties file."); 
		 }
	 }



