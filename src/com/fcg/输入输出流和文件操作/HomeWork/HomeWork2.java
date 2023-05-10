package com.fcg.输入输出流和文件操作.HomeWork;

import java.io.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class HomeWork2 {
    public static void main(String[] args) throws IOException {
        //得到要读取的文件路径、
        String filePath = "E:\\a.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line = " ";
        int count = 0;

         bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath) , "gbk"));
         while((line = bufferedReader.readLine()) != null) {
             count++;
             System.out.println(count  + "   " + line);
         }
         bufferedReader.close();
    }
}
