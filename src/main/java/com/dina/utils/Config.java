package com.dina.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xuhongda on 2020/12/29
 * com.dina.controller
 * car-crash-animation
 */
public class Config {


    private static Logger log = LoggerFactory.getLogger(Config.class);

    /**
     * get config params
     * @param name config's name
     * @return config's value
     */
    public static String getConfig(String name) {
        Properties properties = new Properties();
        String path ="/config.properties";
        try {
            InputStream resourceAsStream = Config.class.getResourceAsStream(path);
            properties.load(resourceAsStream);
        }catch (Exception e){
            log.info("exception = " ,e);
        }
        return properties.getProperty(name);
    }
}
