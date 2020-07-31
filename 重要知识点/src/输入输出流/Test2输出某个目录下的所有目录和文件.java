package 输入输出流;

import java.io.File;

public class Test2输出某个目录下的所有目录和文件 {
    public static void main(String[] args) {
        File file = new File("S:\\");
        if (!file.exists()) {
            System.out.println("目录为空");
            return;
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                System.out.println("目录是：" + files[i].getName());
            } else {
                System.out.println("文件是:" + files[i].getName());
            }
        }

    }
}
