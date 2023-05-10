package com.fcg.输入输出流和文件操作.Properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Properties2 {
    public static void main(String[] args) throws IOException {
        //使用properties创建配置文件
        Properties properties = new Properties();
        //创建
        properties.setProperty("id" , "1234");
        properties.setProperty("pwd" , "123");
        properties.setProperty("user" , "汤姆");

        //将k V储存在配置文件中
        properties.store(new FileWriter("src\\mysql2.properties") , null);


    }
}
