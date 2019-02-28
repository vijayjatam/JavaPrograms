package com.kali.javautil;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {
    public static void main(String[] args) {
        try {
            File outputFileLocation = new File("D:/test/unzipfiles");
            ZipInputStream zip = new ZipInputStream(new FileInputStream(new File("D:/test/zipfiles/two.bz2")));

            ZipEntry zipEntry = zip.getNextEntry();
            byte[] buffer = new byte[1024];
            while (zipEntry!=null){
                String fileName = zipEntry.getName();
                File newFile = new File(outputFileLocation, fileName);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zip.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zip.getNextEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
