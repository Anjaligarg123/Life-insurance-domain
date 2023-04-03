package com.GeneralUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
private String getDataAndTime;
public int random() {
	Random ran=new Random();
	int random=ran.nextInt(1000);
	return random;
}
public String getSystemDate() {
	Date dt = new Date();
	String date=dt.toString();
	return date;
}
public String formatSystemDate() {
	SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy,hh:mm:ss");
	Date dt = new Date();
	String getDateAndTime=dateformat.format(dt);
	getDataAndTime.replace(":","-");
	return getDataAndTime;
	  

}
}
