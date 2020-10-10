package com.utility;

import com.base.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility extends TestBase {

    public static String fetchLocator(String key) throws IOException {

        FileInputStream file = new FileInputStream("./Config/Locators.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }

}
