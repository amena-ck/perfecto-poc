package com.classkickWeb.qa.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

//used to manage run time data for example - sometimes we enter something on the screen - we 
//pick up  data from the screen and we are validating on the other screen 
//we are able to achieve this by using the apache commons to store and fetch data 

public class PropertiesUtils {
	private static PropertiesConfiguration context = new PropertiesConfiguration();
	
	

	public static String loadProperty(String propertyName) {
		Properties propertiesFile = new Properties();
		File propertyFile = new File("src/test/resources/config/config.properties");
		BufferedReader propertyReader;
		try {
			propertyReader = new BufferedReader(new FileReader(propertyFile));
			propertiesFile.load(propertyReader);
			propertyReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertiesFile.getProperty(propertyName);

	}

	public static void loadPropTestData() {
		Configurations configs = new Configurations();
		try {
			context = configs.properties(new File("src//test//resources//config//config.properties"));
		} catch (ConfigurationException cex) {
			cex.printStackTrace();
		}

		for (Object prop : System.getProperties().keySet()) {
			context.setProperty(prop.toString(), System.getProperty(prop.toString()));
		}
	}

	public static PropertiesConfiguration getProperties() {
		return context;
	}

	public static void setProperty(String key, Object obj) {
		getProperties().setProperty(key, obj);
	}

	public static Object getProperty(String key) {
		return getProperties().getProperty(key);
	}

	public static void main(String[] args) {
		PropertiesUtils.loadPropTestData();
		System.out.println(PropertiesUtils.getProperties().getString("RunnerFileName"));

	}
	
	
	public static OutputStream output;
	public static FileReader input;
	public static InputStream inputStream;
	public static Properties config;
	public static FileInputStream fis;
	public static String value;
	public static FileOutputStream fout;

	//validation step 
	public static String getValueFromTestData(String key) throws IOException {
		config = new Properties();
		fis = new FileInputStream("src/test/resources/config/testData.properties");
		config.load(fis);
		value = config.getProperty(key);
		return value;
	}
	
	public static void setValueinTestData(String key,String value) throws IOException {
		
		config = new Properties();
		fis = new FileInputStream("src/test/resources/config/testData.properties");
		config.load(fis);
		fis.close();
		fout = new FileOutputStream("src/test/resources/config/testData.properties");
		config.setProperty(key, value);
		config.store(fout, null);
		fout.close();
		
	}
	
	
	
}





