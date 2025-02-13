package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyName)
	{
       Properties prop = new Properties();
       
       FileInputStream fis=null;
       
		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
			prop.load(fis);
		}

		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{

			e.printStackTrace();
		}
       
      String value = prop.getProperty(propertyName.toUpperCase());
      
      return value;
	}

}
