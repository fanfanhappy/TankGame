package com.fcg.输入输出流和文件操作.inputstream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class FileInputstream {
    public static void main(String[] args) {

    }

    //读取文件方法
    @Test
    public void readFile01()
    {
        //得到文件的路径
        String filePath = "E:\\hello.txt";
        //创建变量储存读取的字节
        int reaadDate = 0;
        //创建FileInputStream对象，对文件进行相应操作
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            //读取字节
            while((reaadDate = fileInputStream.read()) != -1)
            {
                System.out.print((char)reaadDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //方法二
    @Test
    public void readFile02()
    {
        //得到文件的路径
        String filePath = "E:\\hello.txt";
        //设置要读取的字节长度
        byte[] bf = new byte[8];
        //读取的放回值，即实际长度
        int readLength = 0;
        //创建FileInputStream对象，对文件进行相应操作
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            //读取字节
            while((readLength = fileInputStream.read(bf)) != -1)
            {
                System.out.print(new String(bf , 0 , readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
