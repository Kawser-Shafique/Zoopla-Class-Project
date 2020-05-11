package com.confiq;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseConfig {

	public static String getconfig(String key) throws Throwable {

		Properties pro = new Properties();

		String path = "./config.properties";
		FileInputStream fis = new FileInputStream(path);

		pro.load(fis);

		return pro.get(key).toString();
	}

	public static void main(String[] args) throws Throwable {
		System.out.println(BaseConfig.getconfig("URL"));
		System.out.println(BaseConfig.getconfig("Email"));
		System.out.println(BaseConfig.getconfig("Password"));

	}

}
