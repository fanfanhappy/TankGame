package com.fcg.输入输出流和文件操作.outputstream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Fileoutputstream {
    public static void main(String[] args) {

    }

    @Test
    public void writeStream()
    {
        //写入文件的路径
        String filePath = "E:\\a.txt";
        //创建字节输出流对象
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath);
            //写入内容
            fileOutputStream.write('a');
            //写入字符数组，字符串
            String name = "sdawda";
            fileOutputStream.write(name.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
