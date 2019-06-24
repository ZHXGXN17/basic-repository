package com.cn.syncClient.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

public class ZipUtils {

    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);


    public static String zip(String entry, String key) throws ZipException {
        String zipFileName = entry.substring(0, entry.lastIndexOf(".")) + "zip";

        FileUtils.delete(zipFileName);
        ArrayList<File> listFiles = new ArrayList<File>();
        listFiles.add(new File(entry));

        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setAesKeyStrength(3);
        zipParameters.setCompressionLevel(5);
        zipParameters.setCompressionMethod(8);
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(99);
        zipParameters.setPassword(key);

        ZipFile zipFile = new ZipFile(zipFileName);
        zipFile.addFiles(listFiles, zipParameters);

        return zipFileName;
    }


    public static void unzip(String entry, String key, String destPath) throws ZipException{
        if(){

        }

    }
}
