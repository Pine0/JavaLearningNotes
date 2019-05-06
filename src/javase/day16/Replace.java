package javase.day16;

import javase.Student;

import java.util.ArrayList;

public class Replace {
    static boolean replaceAll(ArrayList<Student> stus, Student stu1, Student stu2) {
        int size = stus.size();
        boolean flag = false;
        while (stus.indexOf(stu1) != -1) {
            stus.set(stus.indexOf(stu1), stu2);
            flag = true;
        }
        return flag;
    }
    public static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("soon", 32));
        stus.add(new Student("fangzheng", 22));
        stus.add(new Student("meng", 23));
        System.out.println(replaceAll(stus, new Student("soon", 32), new Student("mama", 22)));
    }
}
