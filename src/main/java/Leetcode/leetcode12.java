package Leetcode;

public class leetcode12 {
    public static void main(String[] args) {
        System.out.print(intToRoman(1994));
    }
    public static String intToRoman(int num) {
        int a[] = new int[13];
        String str[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        a[0] = num / 1000;
        num = num - 1000 * a[0];

        a[1] = num / 900;
        num = num - 900 * a[1];

        a[2] = num / 500;
        num = num - 500 * a[2];

        a[3] = num / 400;
        num = num - 400 * a[3];

        a[4] = num / 100;
        num = num - 100 * a[4];

        a[5] = num / 90;
        num = num - 90 * a[5];

        a[6] = num / 50;
        num = num - 50 * a[6];

        a[7] = num / 40;
        num = num - 40 * a[7];

        a[8] = num / 10;
        num = num - 10 * a[8];

        a[9] = num / 9;
        num = num - 9 * a[9];

        a[10] = num / 5;
        num = num - 5 * a[10];

        a[11] = num / 4;
        num = num - 4 * a[11];

        a[12] = num / 1;
        String s = "";
        for(int i = 0;i < 13;i++){
            for(int j = 0;j < a[i];j++){
                s += str[i];
            }
        }
        return s;
    }

}
