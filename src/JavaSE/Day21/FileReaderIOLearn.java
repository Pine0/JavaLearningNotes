package JavaSE.Day21;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileReaderIOLearn {
    static void IOFunc1() throws IOException {
        try (
                FileReader fr = new FileReader("./src/JavaSE/Day21/file/text.txt");
                ){
                int c;
                while ((c = fr.read()) != -1) {
                    System.out.println((char)c);
            }
        }
    }

    static void IOFunc2() throws IOException {
        try (
                FileReader fr = new FileReader("./src/JavaSE/Day21/file/text.txt");
                FileWriter fw = new FileWriter("./src/JavaSE/Day21/file/text1.txt");
                ){
            char[] bytes = new char[8 * 1024];
            int len = 0;
            while((len = fr.read(bytes)) != -1) {
                fw.write(bytes, 0, len);
            }

        }
    }

    static void IOFunc3() throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("./src/JavaSE/Day21/file/text.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("./src/JavaSE/Day21/file/text1.txt"));
                ){
            int ch = 0;
            while ((ch = br.read()) != -1) {
                bw.write(ch);
            }
        }
    }

    static void reverseText() throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("./src/JavaSE/Day21/file/text.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("./src/JavaSE/Day21/file/text1.txt"));
                ){
            ArrayList<String> txt = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                txt.add(line);
            }
            for (int i = txt.size() - 1; i >= 0; i--) {
                bw.write(txt.get(i));
                bw.newLine();
            }
        }
    }

    static void wordFrequency() throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("./src/JavaSE/Day21/file/text.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("./src/JavaSE/Day21/file/text1.txt"));
                ){
            Map<Character, Integer> map = new HashMap<>();
            int ch = 0;
            while ((ch = br.read()) != -1) {
                map.put((char)ch, !map.containsKey((char)ch)? 1 : map.get((char)ch) + 1);
            }

            for (Character key : map.keySet()) {
                if (key == '\r') {
                    bw.write("\\r : " + map.get(key));
                }
                else if (key == '\n') {
                    bw.write("\\n : " + map.get(key));
                }
                else if (key == '\t') {
                    bw.write("\\t : " + map.get(key));
                }
                else {
                    bw.write(key + " : " + map.get(key));
                }
                bw.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        wordFrequency();
    }
}
