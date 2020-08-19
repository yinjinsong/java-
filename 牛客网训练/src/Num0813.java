import java.util.Arrays;
import java.util.Scanner;

/**
 * lxhgww最近迷上了一款游戏，在游戏里，他拥有很多的装备，每种装备都有2个属性，这些属性的值用[1,10000]之间的数表示。
 * 当他使用某种装备时，他只能使用该装备的某一个属性。并且每种装备最多只能使用一次。
 * 游戏进行到最后，lxhgww遇到了终极boss，这个终极boss很奇怪，攻击他的装备所使用的属性值必须从1开始连续递增地攻击，
 * 才能对boss产生伤害。也就是说一开始的时候，lxhgww只能使用某个属性值为1的装备攻击boss，然
 * 后只能使用某个属性值为2的装备攻击boss，然后只能使用某个属性值为3的装备攻击boss……以此类推。现在lxhgww想知道他最多能连续攻击boss多少次？
 * 输入描述:
 * 输入的第一行是一个整数N，表示lxhgww拥有N种装备
 * 接下来N行，是对这N种装备的描述，每行2个数字，表示第i种装备的2个属性值
 * 输出描述:
 * 输出一行，包括1个数字，表示lxhgww最多能连续攻击的次数。
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 2
 * 3 2
 * 4 5
 * 输出
 * 复制
 * 2
 */
public class Num0813 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=scanner.nextInt();
            arr[i][1]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            if(arr[i][0]>arr[i][1]){
                int t=arr[i][0];
                arr[i][0]=arr[i][1];
                arr[i][1]=t;
            }
        }
        Arrays.sort(arr,(x, y)->x[0]-y[0]);
        if(arr[0][0]!=1)System.out.println(0);
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i][0]==i+1||arr[i][1]==1){
                count++;
            }else{
                break;
            }
        }
        System.out.println(count);
    }
}
