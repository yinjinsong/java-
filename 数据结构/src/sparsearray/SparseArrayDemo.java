package sparsearray;

import java.io.*;

/**
 * 稀疏数组的实现
 * 围棋棋盘11*11
 * 记录围棋盘上的棋子1代表黑子，2代表白子
 */
public class SparseArrayDemo {
    public static void main(String[] args) throws IOException {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][4] = 1;
        //打印原来的二维数组
        showArray(chessArray, "原始的二维数组");

        //将二维数组转换成稀疏数组
        int[][] sparseArray = ArrayToSparse(chessArray);
        showArray(sparseArray, "转换后的稀疏数组");

        //恢复成二维数组
        int[][] ints = SparseToArray(sparseArray);
        showArray(ints, "稀疏数组复原后的二维数组");

        //将稀疏数组存入硬盘中
        ArrayToDisk2(sparseArray);

        //从硬盘txt中读取数据重建稀疏数组
        int[][] ints1 = ReadParseFormDisk2(sparseArray);
        showArray(ints1, "读取txt重建的稀疏数组");

        //将读取的稀疏数组转换成原来的二维数组
        int[][] ints2 = SparseToArray(ints1);
        showArray(ints2,"最终复原的二维数组");


    }

    /**
     * 从硬盘读取txt中的稀疏数组恢复成二维数组
     * @param sparseArray
     * @throws IOException
     */
    private static int[][] ReadParseFormDisk(int[][] sparseArray) throws IOException {
        //读入内存，重建二维数组
        System.out.println("正在从硬盘中读取txt...");
        FileReader fileReader = new FileReader("s:/map.txt");
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while ((len = fileReader.read()) != -1) {
            sb.append((char) len);
        }
        fileReader.close();
        System.out.println("读取完毕...重建稀疏数组中...");
        System.out.println(sb.toString());
        String[] result = sb.toString().split(",");

        //重建稀疏数组

        int[][] sparesArrayFromDisk = new int[result.length/3][3];
        sparesArrayFromDisk[0][0] = Integer.parseInt(result[0]);
        sparesArrayFromDisk[0][1] = Integer.parseInt(result[1]);
        sparesArrayFromDisk[0][2] =  Integer.parseInt(result[2]);

        int curRow = 0;
        for (int i = 3; i < result.length; i += 3) {
            curRow++;
            sparesArrayFromDisk[curRow][0] = Integer.parseInt(result[i]);
            sparesArrayFromDisk[curRow][1] = Integer.parseInt(result[i+1]);
            sparesArrayFromDisk[curRow][2] = Integer.parseInt(result[i+2]);

        }
        System.out.println("重建稀疏数组完毕！");
        return sparesArrayFromDisk;

    }
    private static int[][] ReadParseFormDisk2(int[][] sparseArray) throws IOException {
        //读入内存，重建二维数组
        System.out.println("正在从硬盘中读取txt...");
        //FileReader fileReader = new FileReader("s:/map.txt");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("s:/map.txt")));
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while ((len = bis.read()) != -1) {
            sb.append((char) len);
        }
        System.out.println("读取完毕...重建稀疏数组中...");
        System.out.println(sb.toString());
        String[] result = sb.toString().split(",");

        //重建稀疏数组

        int[][] sparesArrayFromDisk = new int[result.length/3][3];
        sparesArrayFromDisk[0][0] = Integer.parseInt(result[0]);
        sparesArrayFromDisk[0][1] = Integer.parseInt(result[1]);
        sparesArrayFromDisk[0][2] =  Integer.parseInt(result[2]);

        int curRow = 0;
        for (int i = 3; i < result.length; i += 3) {
            curRow++;
            sparesArrayFromDisk[curRow][0] = Integer.parseInt(result[i]);
            sparesArrayFromDisk[curRow][1] = Integer.parseInt(result[i+1]);
            sparesArrayFromDisk[curRow][2] = Integer.parseInt(result[i+2]);

        }
        System.out.println("重建稀疏数组完毕！");
        return sparesArrayFromDisk;

    }
    /**
     * 将数组写入硬盘中
     * @param sparseArray
     * @throws IOException
     */
    private static void ArratToDisk(int[][] sparseArray) throws IOException {
        System.out.println("采用的字符输出流");
        System.out.println("正在将数组写入硬盘中...");
        FileWriter fileWriter = new FileWriter("s:/map.txt");
        for (int[] ints : sparseArray) {
            for (int item : ints) {
                //这一步非常关键，将item转换成String类型
                String s = String.valueOf(item);
                fileWriter.write(s + ",");
            }
            //这个是linux和Windows通用的换行符
            //fileWriter.write(System.getProperty("line.separator"));
        }
        fileWriter.close();
        System.out.println("写入完毕！");

    }
    private static void ArrayToDisk2(int[][] sparseArray) throws IOException {
        System.out.println("采用的字节输出流");
        System.out.println("正在将数组写入硬盘中...");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("s:/map.txt")));
        //FileOutputStream fos = new FileOutputStream("s:/map.txt");
        for (int[] ints : sparseArray) {
            for (int item : ints) {
                //这一步非常关键，将item转换成String类型
                String s = String.valueOf(item);
               bos.write((s + ",").getBytes());
            }
            //这个是linux和Windows通用的换行符
            //fileWriter.write(System.getProperty("line.separator"));
        }
        bos.close();
        System.out.println("写入完毕！");

    }
    /**
     * 打印二维数组
     * @param sparesArrayFromDisk
     * @param s2
     */
    private static void showArray(int[][] sparesArrayFromDisk, String s2) {
        System.out.println(s2);
        for (int[] ints : sparesArrayFromDisk) {
            for (int item : ints) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    /**
     * 将稀疏数组转化成二维数组
     * @param sparseArray
     * @return
     */
    private static int[][] SparseToArray(int[][] sparseArray) {
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            }
        }
        return chessArray2;
    }

    /**
     * 将二维数组转换成稀疏数组
     *
     *             1.记录有效数据的个数
     *             2.根据有效个数创建稀疏数组
     *             3.记录有效数值的位置
     *
     * @param chessArray
     * @return
     */
    private static int[][] ArrayToSparse(int[][] chessArray) {
        //有效数据个数
        int count = 0;
        for (int[] ints : chessArray) {
            for (int item : ints) {
                if (item != 0) {
                    count++;
                }
            }
        }
        int row = 1;
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = count;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = chessArray[i][j];
                    row++;
                }
            }
        }
        return sparseArray;
    }


}
