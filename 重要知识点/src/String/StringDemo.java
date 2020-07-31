package String;

import java.lang.reflect.Method;

public class StringDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "123";
        System.out.println(appendStr(s));
        System.out.println(s);

        Class<?> string = Class.forName("java.lang.String");
        Method[] methods = string.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("===================================");
        Method[] declaredMethods = string.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    private static String appendStr(String s) {
        s += "aaaaaa";
        return s;
    }
}
