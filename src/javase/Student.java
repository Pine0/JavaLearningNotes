package javase;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "My name is " + this.name + " my age is " + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        Student stu = (Student) obj;
        return this.name.equals(stu.getName()) && this.age == stu.getAge();
    }



}
