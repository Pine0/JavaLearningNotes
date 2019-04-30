package JavaSE.Day20;

import java.io.*;
import java.util.Scanner;


public class StreamIOLearn {
    static void IOFunc1() throws IOException {
        //IO函数1：将fis中的文字写入fos
        FileInputStream fis = new FileInputStream("./src/JavaSE/Day20/file/xxx.txt");
        FileOutputStream fos = new FileOutputStream("./src/JavaSE/Day20/file/yyy.txt");
        int b = 0;
        while ((b = fis.read()) != -1) {
            //一次读入一个字节 (0-255)
            fos.write(b);
        }
        fis.close();
        fos.close();
    }

    static void IOFunc2() throws IOException {
        //IO函数2：续写fos
        FileOutputStream fos = new FileOutputStream("./src/JavaSE/Day20/file/yyy.txt", true);
        fos.write(98);
        fos.close();
    }

    static void IOFunc3() throws IOException {
        //IO函数3：将文件整个读入内存，再整个输出到文件
        FileInputStream fis = new FileInputStream("./src/JavaSE/Day20/file/致青春.mp3");

        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);

        FileOutputStream fos = new FileOutputStream("./src/JavaSE/Day20/file/copy致青春.mp3");
        fos.write(bytes);

        fis.close();
        fos.close();
    }

    static void IOFunc4() throws IOException { //IO函数4：使用8kB的缓冲将数据读入内存在写入文件
        FileInputStream fis = new FileInputStream("./src/JavaSE/Day20/file/双元.jpg");
        FileOutputStream fos = new FileOutputStream("./src/JavaSE/Day20/file/copy.jpg");
        byte[] buf = new byte[8 * 1024];
        int len;
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fis.close();
        fos.close();
    }

    static void IOFunc5() throws IOException {
        FileInputStream fis = new FileInputStream("./src/JavaSE/Day20/file/致青春.mp3");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("./src/JavaSE/Day20/file/copy致青春.mp3");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int c = 0;
        while ((c = bis.read()) != -1) {
            bos.write(c);
        }
    }

    static void IOFunc6() throws IOException {
        //Java1.7版本处理IO流标准写法
        try(
                FileInputStream fis = new FileInputStream("./src/JavaSE/Day20/file/致青春.mp3");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("./src/JavaSE/Day20/file/copy致青春.mp3");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ){
            int c = 0;
            while ((c = bis.read()) != -1) {
                bos.write(c);
            }
        }
    }

    static void IOFunc7() throws IOException {
        //图片加密
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/JavaSE/Day20/file/致青春.mp3"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./src/JavaSE/Day20/file/copy致青春.mp3"));
                ){
            int c = 0;
            while ((c = bis.read()) != -1) {
                bos.write(c ^ 123);
            }
        }
    }

    static void IOFunc8() throws IOException {
        try (
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./src/JavaSE/Day20/file/text.txt", true));
                ){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            bos.write(s.getBytes());
        }
    }


    public static void main(String[] args) throws IOException{
        IOFunc8();

    }
}
