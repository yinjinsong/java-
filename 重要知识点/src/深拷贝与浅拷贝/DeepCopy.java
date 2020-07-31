package 深拷贝与浅拷贝;

import java.io.*;

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //1.通过实现cloneable接口来实现深拷贝，即在把基本类型clone后将引用对象类型还要再单独clone一次
        Student s1 = new Student(10, "zhangsan", new School(9, "九中"));
        Student s2 = s1.clone();
        System.out.println(s1);
        System.out.println(s2);
        //如果school不重写clone方法，则s2获取到的school对象和s1是指向的同一个
        s2.getSchool().setGrade(111);
        System.out.println(s1);
        System.out.println(s2);

        //2.序列化方式实现深拷贝
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        oos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        Student student = (Student) ois.readObject();
        ois.close();

        System.out.println(student);

    }
}

class Student implements Cloneable, Serializable {
    private static final long serialVersionUID = 2631590509760908280L;

    private int age;
    private String name;
    private School school;

    public Student(int age, String name, School school) {
        this.age = age;
        this.name = name;
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "深拷贝与浅拷贝.Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school=" + school +
                '}';
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student clone = (Student) super.clone();
        clone.school = school.clone();
        return clone;
    }
}

class School implements Cloneable,Serializable{
    private static final long serialVersionUID = 2631590509760908289L;
    private int grade;
    private String schoolName;

    public School(int grade, String schoolName) {
        this.grade = grade;
        this.schoolName = schoolName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    @Override
    protected School clone() throws CloneNotSupportedException {
        return (School)super.clone();
    }
}
