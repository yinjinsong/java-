import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int colum = scanner.nextInt();
        int[][] arr = new int[row][colum];
        for (int i = 0; i < row; i++) {
            String s = scanner.next();
            for (int j = 0; j < colum; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        demo4(arr,row-1,colum-1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (j != colum - 1) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.println(arr[i][j]);
                }

            }
            System.out.println();
        }
    }

    public static void demo4(int[][] arr,int row,int colum) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (arr[i][j] == 1) {
                    int tempi = i;
                    int tempj = j;
                    int minDistance = Integer.MAX_VALUE;
                    //向上搜索
                    while (tempi >= 0) {
                        if (arr[tempi][j] == 0) {
                            minDistance = Math.min(minDistance, i - tempi);
                            break;
                        }
                        tempi--;
                    }
                    tempi = i;
                    tempj = j;
                    //向下搜索
                    while (tempi <= row) {
                        if (arr[tempi][j] == 0) {
                            minDistance = Math.min(minDistance, tempi - i);
                            break;
                        }
                        tempi++;
                    }
                    tempi = i;
                    tempj = j;
                    //向右搜索
                    while (tempj <= colum) {
                        if (arr[i][tempj] == 0) {
                            minDistance = Math.min(minDistance, tempj - j);
                            break;
                        }
                        tempj++;
                    }
                    tempi = i;
                    tempj = j;
                    //向左搜索
                    while (tempj >= 0) {
                        if (arr[i][tempj] == 0) {
                            minDistance = Math.min(minDistance, j - tempj);
                            break;
                        }
                        tempj--;
                    }
                    arr[i][j] = minDistance;
                }
            }
        }



    }

}
