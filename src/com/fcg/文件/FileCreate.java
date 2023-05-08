package com.fcg.文件;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class FileCreate {
    public static void main(String[] args)
    {

    }
    //方法一 new Filr(String pathname)
    @Test
    public void create01()
    {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方法二
    @Test
    public void create02()
    {
        File fileParent = new File("e:\\");
        String fileName = "news02.txt";
        File file = new File(fileParent, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方法三
    @Test
    public void create03()
    {
        String parentPath = "e:\\";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
