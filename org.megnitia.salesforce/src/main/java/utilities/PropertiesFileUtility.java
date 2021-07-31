package utilities;

import java.io.FileInputStream;

import java.util.Properties;
//how to access data from config.properties file
public class PropertiesFileUtility 
{
	//operational static method
	//why here only one parameter as a string(String propertyname)
    //every project is having only one  "config.properties" file by default
	public static String getValueInPropertiesFile(String propertyname) throws Exception
	{
		//path of properties file with current directory path
		String pfpath = System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties";
		//Access existing properties file,which consists of common data or setup data
		//Take the read permission  by specifying the path(shift file from hard disk to RAM)
		FileInputStream f = new FileInputStream(pfpath);
		//load the properties file by using load() method in "Properties" class
		Properties p = new Properties();
		p.load(f);
		//get the value from properties file by passing same name as parameter
		// in that loaded properties file with our given property name it will take value
		String value = p.getProperty(propertyname);
		//close the read permission
		f.close();
		//that value it can return
		return(value);
		
		//property name is input,value of property is output in corresponding file
		//when we want data from properties file simply we can call getValueInPropertiesFile() by
		//passing propertyname(as a input)
	}

}
