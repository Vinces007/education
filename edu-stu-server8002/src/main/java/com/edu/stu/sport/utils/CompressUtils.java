package com.edu.stu.sport.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressUtils {
   private static String ZIP_FILE = "D://Myzip.zip";
   private static String JPG_FILE = "D://java//sportData//ss_20210824_1629786613943.xml";
   private static String FILE_NAME = "ss_20210824_1629786613943.xml";
   private static  long FILE_SIZE;
    static {

        File file = new File(JPG_FILE);
        FILE_NAME = file.getName();
        FILE_SIZE = file.length();
    }
    public static void main(String[] args) {
        zipFileBuffer();
    }


    /**
     * 使用了Buffer
     */
    public static void zipFileBuffer() {
        //开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(JPG_FILE))) {
                zipOut.putNextEntry(new ZipEntry(FILE_NAME ));
                int temp = 0;
                while ((temp = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(temp);
                }
            }

            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用Channel
     */
    public static void zipFileChannel() {
        //开始时间
        long beginTime = System.currentTimeMillis();
        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 10; i++) {
                try (FileChannel fileChannel = new FileInputStream(JPG_FILE).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(i + FILE_NAME));
                    fileChannel.transferTo(0, FILE_SIZE, writableByteChannel);
                }
            }
            printInfo(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInfo(long beginTime) {
        //耗时
        long timeConsum = (System.currentTimeMillis() - beginTime);
        System.out.println("consum time:" + timeConsum);
    }
}