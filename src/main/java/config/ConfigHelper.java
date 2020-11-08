package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHelper 
{
	InputStream input;
	Properties prop;
	String HOST;
	String KEY;


	private ConfigHelper()
	{
		readProperties();
	}
	
	static ConfigHelper confHelp = new ConfigHelper();

	public static ConfigHelper getConfHelp() 
	{
		return confHelp;
	}
	
	public String getHOST() 
	{
		return HOST;
	}
	
	public String getKEY() 
	{
		return KEY;
	}


	public void readProperties()
	{
		try 
		{
			input = new FileInputStream(".//src//config.properties");
			prop = new Properties();
			prop.load(input);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		HOST = prop.getProperty("HOST");
		KEY = prop.getProperty("KEY");
	}
	

}
