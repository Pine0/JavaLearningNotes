package JavaSE.Day16;

import JavaSE.Student;

import java.util.ArrayList;

public class EleTimes {
    static int frequency(ArrayList<Student> list, String name) {
        int times = 0;
        for (Student stu : list)
            if (stu.getName().equals(name))
                times++;
        return times;
    }
    public static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("soon", 32));
        stus.add(new Student("fangzheng", 22));
        stus.add(new Student("meng", 23));
        System.out.println(frequency(stus, "soon"));

    }
}
