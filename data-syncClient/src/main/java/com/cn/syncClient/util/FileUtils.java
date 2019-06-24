package com.cn.syncClient.util;

import java.io.File;

public class FileUtils {

    public static void delete(String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
    }


}
