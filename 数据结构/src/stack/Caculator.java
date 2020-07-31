package stack;

public class Caculator {
    public static void main(String[] args) {
        Stack3 numStack = new Stack3(10);
        Stack3 opeStack = new Stack3(10);
        String expression = "2-3*6/2+11";
        //String expression = "2-4-100/20*200+2";
        int index = 0;//指向表达式的当前面位置
        int num1 = 0;
        int num2 = 0;
        String keepNum = "";
        char ch = '0';

        while (index < expression.length()) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (Stack3.isOperator(ch)) {
                //是操作符需要判断符号栈是否为空
                if (opeStack.isEmpty()) {
                    //如果为空则直接放入
                    opeStack.push(ch);
                } else {
                    //如果已经有操作符，则需要比较优先级
                    //如果当前符号优先级小于等于栈中符号则取出两个数进行计算,一直遍历下去
                    while (!opeStack.isEmpty() && Stack3.priority(ch) <= Stack3.priority(opeStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int res = Stack3.operator(num1, num2, opeStack.pop());
                        //计算完之后需要把计算结果压入数栈中
                        numStack.push(res);
                    }
                    //如果当前符号优先级大于栈中符号或者运算完之后栈为空则直接压栈
                    opeStack.push(ch);

                }
                index++;
            } else {
                //如果操作数是数字，则需要判断后一位是否还是数字，如果是数字
                //则还需要拼接字符串，如果是操作符则直接压栈
                //需要判断当前是不是最后一位，如果是最后一位则直接压入数栈
                keepNum += ch;
                if (index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //如果下一位是数字，则继续拼接
                   if(Stack3.isOperator(expression.substring(index+1,index+2).charAt(0))) {
                        //如果下一位是操作符则直接将keepnum的结果压入数栈
                        //并将keepNum清空!!!!
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
                index++;

            }

        }
        //表达式扫描完毕后需要计算剩余两个栈中的数据
        //操作符栈不为空说明还未计算鞍鼻
        while (!opeStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            int res = Stack3.operator(num1, num2, opeStack.pop());
            numStack.push(res);
        }
        //最后只剩下数栈中有数，就是结果
        System.out.printf("%s的计算结果是：%d", expression, numStack.pop());
    }
}


class Stack3{
    private int maxSize;//最大容量
    private int[] stack;//存储数据的数组
    private int top = -1;//栈顶

    /**
     * 构造方法，传入最大容量
     * @param maxSize
     */
    public Stack3(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * 判断栈是否已经满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 压栈操作
     * @param num
     */
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈满，无法继续压入数据！");
        }
        top++;
        stack[top] = num;
    }

    /**
     * 出栈操作
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法取出数据！");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 打印栈
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈是空的~~");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]:%d\n", i, stack[i]);
        }
    }

    /**
     * 查看栈顶数据
     * @return
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 判断是否是运算符
     * @param ch
     * @return
     */
    public static boolean isOperator(int ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算
     * @param num1 栈顶的数
     * @param num2 栈顶的下一个数
     * @param ope 操作符号
     * @return
     */
    public static int operator(int num1, int num2, int ope) {
        int sum = 0;
        switch (ope) {
            case '+':
                sum= num1 + num2;
                break;
            case '-':
                sum= num2 - num1;
                break;
            case '*':
                sum= num1 * num2;
                break;
            case '/':
                if (num1 == 0) {
                    throw new RuntimeException("除数为0");
                }
                sum= num2 / num1;
                break;
            default:
                break;
        }
        return sum;
    }

    /**
     * 判断运算符的优先级
     * @param oper
     * @return
     */
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else {
            return 0;
        }
    }


}