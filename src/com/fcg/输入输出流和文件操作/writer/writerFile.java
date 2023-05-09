package com.fcg.输入输出流和文件操作.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class writerFile {
    public static void main(String[] args) {
        //得到要写入的文件路径
        String filePath = "E:\\TT.txt";

        //创建字符输出流对象
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            //定义写入内容
            fileWriter.write('a');
            //写入字符串
            fileWriter.write("你好，北京");
            //写入字符数组
            char[] buf = {'1' , '2' , '3'};
            fileWriter.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //关闭流
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
