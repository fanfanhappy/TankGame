package com.fcg.输入输出流和文件操作.HomeWork;

import java.io.File;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class HomeWork1 {
    public static void main(String[] args) throws IOException {
        //得到文件路径
        String filePath = "E:\\mytemp";
        File file = new File(filePath);
        if(file.exists() == false)
        {
            file.mkdir();
        }
        String afilePath = "E:\\mytemp\\hello.txt";
        File file1 = new File(afilePath);
        if(file1.exists() == false)
        {
            file1.createNewFile();
        }

    }
}
