package com.fcg.输入输出流和文件操作.writer;

import java.io.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class BufferedCopy {
    public static void main(String[] args) {
        //要拷贝文件的路径
        String filePath = "E:\\a.txt";
        //被拷贝文件路径
        String newfilePath = "E:\\b.txt";

        //创建BufferedReader对象
        BufferedReader bufferedReader = null;
        String line = " ";
        //创建BfferedWriter对现象
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            bufferedWriter = new BufferedWriter(new FileWriter(newfilePath));
            while((line = bufferedReader.readLine()) != null)
            {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(bufferedReader != null)
                {
                    bufferedReader.close();
                }
                if(bufferedWriter != null)
                {
                    bufferedWriter.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
