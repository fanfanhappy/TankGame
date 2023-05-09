package com.fcg.输入输出流和文件操作.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        //得到文件路径
        String filePath = "D:\\0ba88d8a36a0db671be760ff45a79fe4.jpg";
        //得到要拷贝的路径
        String newfilePath = "E:\\0ba88d8a36a0db671be760ff45a79fe4.jpg";
        //创建变量储存读取的字节
        int readDate = 0;
        //创建FileInputstream对象，对文件进行操作
        FileInputStream fileInputStream = null;
        //创建FileOtputStream
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(newfilePath);
            //读取数据
            while((readDate = fileInputStream.read()) != -1)
            {
                fileOutputStream.write(readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
