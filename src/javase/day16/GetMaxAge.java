package javase.day16;

import javase.Student;

import java.util.ArrayList;

public class GetMaxAge {
    static Student getMaxAge(ArrayList<Student> stus) {
        int index = -1, maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for(Student stu : stus) {
            max = stu.getAge();
            index++;
            if (max < stu.getAge()) {
                max = stu.getAge();
                maxIndex = index;
            }
        }
        return stus.get(maxIndex);
    }
    public static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("soon", 32));
        stus.add(new Student("fangzheng", 22));
        stus.add(new Student("meng", 23));
        System.out.println(getMaxAge(stus));
    }
}
