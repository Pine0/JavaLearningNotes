package javase;

import java.util.ArrayList;
import java.util.Iterator;

public class ALDistinct {
    static boolean distinct(ArrayList<Student> stus) {
        ArrayList<Student> res = new ArrayList<>();
        for (Iterator<Student> it = stus.iterator(); it.hasNext(); ) {
            Student stu = it.next();
            if (!res.contains(stu)){
                res.add(stu);
            }
        }
        return stus.size() == res.size();
    }
    public  static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));
        stus.add(new Student("soon", 20));

        System.out.println(distinct(stus));
    }
}
