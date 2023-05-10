package com.fcg.输入输出流和文件操作.Properties_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class properties1 {
    public static void main(String[] args) throws IOException {
        //使用properties读取配置文件

        //创建properties对象
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //把k_y显示到控制台
        properties.list(System.out);
        String user = properties.getProperty("user");
        System.out.println(user);
    }
}
