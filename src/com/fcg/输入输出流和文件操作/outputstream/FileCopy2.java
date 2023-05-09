package com.fcg.输入输出流和文件操作.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class FileCopy2 {
    public static void main(String[] args){
        //得到要读取的文件路径
        String filePath = "D:\\0ba88d8a36a0db671be760ff45a79fe4.jpg";
        //得到要拷贝的文件路径
        String newfilePath = "E:\\0ba88d8a36a0db671be760ff45a79fe4.jpg";
        //得到输入流对象 FileInputStream对象
        FileInputStream fileInputStream = null;
        //使用字符数组读取
        byte[] bf = new byte[1024];
        int readLen = 0;
        //得到输出流对象FileOutputStream
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(newfilePath);
            while((readLen = fileInputStream.read(bf)) != -1)
            {
                //写入文件

                fileOutputStream.write(bf , 0 , readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if(fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
