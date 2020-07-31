package 序列化;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person yjs = new Person(11, "yjs");

        //方式1
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("people.out"));
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(yjs);
//        oos.close();
//
//        Person p;
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("people.out"));
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        p = (Person) ois.readObject();
//        System.out.println(p);
//        ois.close();
//        bis.close();

        //方式2
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(yjs);
        oos.close();
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Person person = (Person) ois.readObject();
        System.out.println(person);
    }
}

class Person implements Serializable {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}