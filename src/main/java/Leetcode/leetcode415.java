package Leetcode;
public class leetcode415 {
    public static void main(String[] args) {
        String a = "11";
        String b ="9";
        System.out.println(addStrings(a,b));
    }
    public static String addStrings(String num1,String num2){
        StringBuilder build = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int sum;
        int sign = 0;
        while(index1 >= 0 && index2 >= 0){
            sum =  num1.charAt(index1)  + num2.charAt(index2)  - 2 * '0' + sign;
            if(sum >= 10){
                build.insert(0,sum - 10);
                sign = 1;
            }
            else{
                build.insert(0,sum);
                sign = 0;
            }
            index1 --;
            index2 --;
        }
        if(index1 == -1 && index2 == -1 ){
            if(sign == 1){
                build.insert(0,1);
                return build.toString();
            }
            else
                return build.toString();
        }
        if(index1 >= 0) {
            while (index1 >= 0) {
                sum = num1.charAt(index1) - '0' + sign;
                if (sum >= 10) {
                    build.insert(0, sum - 10);
                    sign = 1;
                } else {
                    build.insert(0, sum);
                    sign = 0;
                }
                index1--;
                if (index1 < 0 && sign == 1) {
                    build.insert(0, 1);
                    return build.toString();
                } else if (index1 < 0) {
                    return build.toString();
                }
            }
        }
        if(index2 >= 0) {
            while (index2 >= 0) {
                sum = num2.charAt(index2) - '0' + sign;
                if (sum >= 10) {
                    build.insert(0, sum - 10);
                    sign = 1;
                } else {
                    build.insert(0, sum);
                    sign = 0;
                }
                index2--;
                if (index2 < 0 && sign == 1) {
                    build.insert(0, 1);
                    return build.toString();
                } else if (index2 < 0) {
                    return build.toString();
                }
            }
        }
        return build.toString();
    }
}
