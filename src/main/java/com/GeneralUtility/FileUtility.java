package com.GeneralUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		 String value=p.getProperty(key);
		return value;
	}

}
