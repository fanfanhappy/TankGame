package com.fcg.输入输出流和文件操作.inputstream;

import java.io.*;
import java.io.BufferedInputStream;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class BufferedInputStream2 {
    public static void main(String[] args) {
        String filePath = "D:\\崩坏：星穹铁道 2023-05-03 10-46-13.mp4";
        String newfilePath = "E:\\崩坏：星穹铁道 2023-05-03 10-46-13.mp4";
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        int dtat = 0;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newfilePath));
            while((dtat = bufferedInputStream.read()) != -1)
            {
                bufferedOutputStream.write(dtat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
