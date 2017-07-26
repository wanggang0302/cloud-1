package com.jfsoft.utils;

import java.io.File;

/**
 * 文件工具类
 * wanggang
 * 2017/7/19
 */
public class FileUtil {

    public static void deleteFilesByType(String filePath, String fileType) throws Exception {
        File file=new File(filePath);
        File[] files=file.listFiles();//获取文件列表
        for(int i=0;i<files.length;i++)
        {
            if(!files[i].isFile()) continue;//如果不是文件就跳过（排除文件夹等）
            String fileName = files[i].getName();
            if(fileName.toLowerCase().endsWith(fileType.toLowerCase())) {
                files[i].delete();//后缀名为fileType就删除
            }
        }
    }

}
