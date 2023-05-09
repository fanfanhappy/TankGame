package com.fcg.输入输出流和文件操作.writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class BufferedRead {
    public static void main(String[] args) {
        //获取文件路劲
        String filePath = "E:\\a.txt";
        FileReader fileReader = null;
        String line = " ";
        BufferedReader buff = null;
        try {
            fileReader = new FileReader(filePath);
           buff = new BufferedReader(fileReader);
            while((line = buff.readLine()) != null)
            {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
       finally {
            try {
                buff.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
