package Readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;

public class ConfigReader {
	public String browser;

	public ConfigReader() throws IOException {
		 String path=  System.getProperty("user.dir");
		FileReader reader = new FileReader(
				path+"\\src\\main\\resources\\config.properties");
		Properties p = new Properties();
		p.load(reader);
		browser = p.getProperty("Browser");
	}

	public String browserName() throws IOException {
		return browser;
	}
}
