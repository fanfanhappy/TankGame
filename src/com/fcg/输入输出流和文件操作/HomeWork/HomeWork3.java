package com.fcg.输入输出流和文件操作.HomeWork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class HomeWork3 {
    public static void main(String[] args) throws IOException {
        //先创建properties对象
        Properties properties = new Properties();
        //输入键值对
        properties.setProperty("name" , "tom");
        properties.setProperty("age" , "5");
        properties.setProperty("color" , "red");
        //储存到配置文件中
        properties.store(new FileWriter("src\\mysql3.properties"), null);
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);
    }
}

class Dog
{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}