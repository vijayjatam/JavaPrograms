package com.kali;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    public static void main(String[] args) {
        try {
            File outputFileLocation = new File("D:/test/unzipfiles");
            ZipInputStream zip = new ZipInputStream(new FileInputStream(new File("D:/test/zipfiles/two.bz2")));
            BZip2CompressorInputStream bzip = new BZip2CompressorInputStream(new FileInputStream(new File("D:/test/zipfiles/two.bz2")));
            ZipEntry zipEntry = zip.getNextEntry();
            byte[] buffer = new byte[8*1024];
            String fileName = "two.csv";//zipEntry.getName();
            File newFile = new File(outputFileLocation, fileName);

            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = bzip.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            bzip.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
