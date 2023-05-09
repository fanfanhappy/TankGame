package com.fcg.输入输出流和文件操作.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class readFile {
    public static void main(String[] args) {
        //获取文件路径
        String filePath = "E:\\a.txt";
        //创建字符输入流对象
        FileReader fileReader = null;
        //储存读取数据
        int date = 0;

        try {
            fileReader = new FileReader(filePath);
            //循环读取文件数据
            //一个一个字符的读取
            while((date = fileReader.read()) != -1)
            {
                System.out.print((char)date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileReader != null)
                {
                    fileReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
