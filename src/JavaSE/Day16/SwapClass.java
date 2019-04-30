package JavaSE.Day16;


import JavaSE.Student;

import java.util.ArrayList;
import java.util.Collections;

public class SwapClass {
    public static void main(String[] args) {
        ArrayList<Student> stus = new ArrayList<>();
        stus.add(new Student("soon", 32));
        stus.add(new Student("fangzheng", 22));
        stus.add(new Student("meng", 23));
        Collections.swap(stus, 1, 2); //swap 调用的的二重set，set方法返回的是原来的元素

    }
}
