package com.Ecommerce.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class FileUtility {
	FileInputStream f;
	Properties p;

	public String readDataFromProperty(String path, String key) {
		try {
			f = new FileInputStream(path);
			p = new Properties();
			p.load(f);
		} catch (Exception e) {
			Reporter.log("Exception handled successfully", true);
		}
		return p.getProperty(key);

	}

}
