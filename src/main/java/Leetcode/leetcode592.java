package Leetcode;

public class leetcode592 {

    public static void main(String[] args) {
        System.out.println(fractionAddition( "1/3-1/2"));
    }


    public static String fractionAddition(String expression) {
        int fenzi = 0;
        int fenmu = 1;
        int len = 1;
        int i = 0;
        int[] up = new int[10];
        int[] down = new int[10];
        int index1 = 0;
        int index2 = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                if (i < expression.length() - 1 && expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9') {
                    if (len % 2 == 1) {
                        up[index1++] = 10;
                        len++;
                    }
                    else {
                        down[index2++] = 10;
                        len++;
                    }
                    i += 2;
                }
                else {
                    if (len % 2 == 1) {
                        up[index1++] = expression.charAt(i) - '0';
                        len++;
                    }
                    else {
                        down[index2++] = expression.charAt(i) - '0';
                        len++;
                    }
                    i++;
                }
            }
            else {
                i++;
            }
        }
        for (i = 0; i < index2; i++) {
            fenmu = Min(fenmu, down[i]);
        }
        int index = 0;
        if (expression.charAt(0) >= '0' && expression.charAt(0) <= '9') {
            fenzi = fenzi + up[index] * fenmu / down[index];
            index++;
        }
        for (i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-') {
                fenzi = fenzi - up[index] * fenmu / down[index];
                index++;
            }
            else if (expression.charAt(i) == '+') {
                fenzi = fenzi + up[index] * fenmu / down[index];
                index++;
            }
        }
        if (fenzi == 0) {
            return fenzi + "/" + 1;
        }
        int temp = Max(Math.abs(fenzi),fenmu);
        fenzi /= temp;
        fenmu /= temp;
        return fenzi + "/" + fenmu;
    }

    public static int Min(int a,int b) {
        return a * b / Max(a,b);
    }

    public static int Max(int a,int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
