package JavaSE.Day16;

import JavaSE.Student;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseAL {
    static boolean reverseAL(ArrayList list) {
        if (list.size() == 0) return false;
        for (int i = 0; i < list.size() / 2; i++) {
            Collections.swap(list, i, list.size() - i - 1);
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("soon", 32));
        stus.add(new Student("fangzheng", 22));
        stus.add(new Student("meng", 23));
        System.out.println(reverseAL(stus));

    }
}
