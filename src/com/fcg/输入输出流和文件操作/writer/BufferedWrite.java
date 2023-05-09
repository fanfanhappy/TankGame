package com.fcg.输入输出流和文件操作.writer;

import java.io.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class BufferedWrite {
    public static void main(String[] args) {
        String filePath = "E:\\TT.txt";
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            String data = "你好，北京";
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
