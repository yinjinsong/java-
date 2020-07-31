package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RePolanCaculator {
    /*
        要求输入一个中缀表达式，将其转化为后缀表达式。
        然后计算出后缀表达式的值
     */
    public static void main(String[] args) {
       // String expression = "21+(3*4)+5";
        //String expression = "1+((2+3)*4)-5";
        String expression = "((1+((2+3)*4)-5))";
        //1.首先将string每一位扫描加入数组[21,+,(,3,*,4,),+,5]
        ArrayList<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        //2.将中缀表达式数组转化为后缀表达式数组
        List<String> suffixExpreesionList = parseSuffixExpreesionList(list);
        System.out.println(suffixExpreesionList);
        //3.计算后缀表达式的值
        int result = caculate(suffixExpreesionList);
        System.out.printf("%s的计算结果是：%d", expression, result);
    }



    /**
     * 将中缀表达式转化成对应的字符串数组
     * @param ex
     * @return
     */
    public static ArrayList<String> toInfixExpressionList(String ex) {
        int index = 0;
        String tmp = "";
        ArrayList<String> list = new ArrayList<>();
        while (index < ex.length()) {
            char ch = ex.charAt(index);
            if (ch < '0' || ch > '9') {
                //如果是小括号或者运算符则直接加入数组
                list.add("" + ch);
                index++;
            } else {
                //如果是数字，则需要在判断下一位是否还是数字
                while (index < ex.length() && (ex.charAt(index) >= '0' && ex.charAt(index)<= '9')) {
                    tmp += ex.charAt(index);
                    index++;
                }
                list.add(tmp);
                //清空tmp
                tmp = "";
            }
        }
        return list;
    }

    /**
     * 将中缀表达式数组解析成后缀表达式数组
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String s : ls) {
            if (s.matches("\\d+")) {
                //如果是数字，则直接加入s2容器
                s2.add(s);
            } else if (s.equals("(")) {
                //如果是左括号，则直接加入s1容器
                s1.push(s);
            } else if (s.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，
                // 直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //当扫描到运算符号时，需要比较优先级
                //当s的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，
                // 再次与s1中新的栈顶运算符相比较，如果s1为空则直接加入
                while (s1.size() != 0 && Operation.getValue(s) <= Operation.getValue(s1.peek())) {
                    s2.add(s1.pop());
                }
                //将s入栈s1
                s1.push(s);
            }
        }
        //将s1中剩余的元素全部加入s2
        while (!s1.empty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 计算后缀表达式的值
     * @param suffix
     * @return
     */
    public static int caculate(List<String> suffix) {
        Stack<String> stack = new Stack<String>();
        for (String item : suffix) {
            if (item.matches("\\d+")) {
                //如果是数字则入栈
                stack.push(item);
            } else {
                //如果是运算符，则弹出两个数进行运算完再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = Operation.calTwoNum(num1, num2, item);
                stack.push(String.valueOf(result));
            }
        }
        //最后一个留在栈中的数是结果
        return Integer.parseInt(stack.pop());

    }

}


class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                //当时(时，默认他的优先级为0，运算符可以直接压入s1
                break;
        }
        return result;
    }

    /**
     * 根据运算符计算两个数运算的结果
     * @param num1
     * @param num2
     * @param ope
     * @return
     */
    public static int calTwoNum(int num1, int num2, String ope) {
        if (ope.equals("+")) {
            return num1 + num2;
        } else if (ope.equals("-")) {
            return num1 - num2;
        } else if (ope.equals("*")) {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }
}