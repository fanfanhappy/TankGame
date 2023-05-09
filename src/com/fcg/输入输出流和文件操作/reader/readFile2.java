package com.fcg.输入输出流和文件操作.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class readFile2 {
    public static void main(String[] args) {
        //得到文件路径
        String filePath = "E:\\a.txt";
        FileReader fileReader = null;
        //定义一个字符数组，进行多次读取
        char[] buf = new char[8];
        //定义数据储存变量
        int readLen = 0;

        //开始循环读取
        try {
            fileReader = new FileReader(filePath);
            //循环读取
            while((readLen = fileReader.read(buf)) != -1)
            {
                //输出读取文件,将字符数组转成字符串
                System.out.print(new String(buf , 0 , readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //释放流资源
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
