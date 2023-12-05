package Leetcode;

public class leetcode67 {
    public static void main(String[] args) {
        String a = "110010";
        String b = "10111";
        System.out.println(addBinary(a,b));
        System.out.println(BinaryToDec("0"));
        System.out.println(BinaryToDec(b));
        System.out.println(DecToBinary(23));
        System.out.println(addBinary2("0","0"));


    }



    public static String addBinary(String a, String b) {
        int lengthofa = a.length() - 1;
        int lengthofb = b.length() - 1;
        String str = "";
        int flag = 0;
        while(lengthofa >= 0 && lengthofb >= 0){
            if(a.charAt(lengthofa) == '1' && b.charAt(lengthofb) == '1'){
                if(flag == 0){
                    str = '0' + str;
                    flag = 1;
                    lengthofa--;
                    lengthofb--;
                }
                else{
                    str = '1' + str;
                    lengthofa--;
                    lengthofb--;
                }
            }
            else if(a.charAt(lengthofa) == '1' || b.charAt(lengthofb) == '1'){
                if(flag == 0){
                    str = '1' + str;
                    lengthofa--;
                    lengthofb--;
                }
                else{
                    str = '0' + str;
                    lengthofa--;
                    lengthofb--;
                }
            }
            else{
                if(flag == 0){
                    str = '0' + str;
                    lengthofa--;
                    lengthofb--;
                }
                else{
                    str = '1' + str;
                    flag = 0;
                    lengthofa--;
                    lengthofb--;
                }
            }
        }
        if(lengthofa >= 0){
            while(lengthofa >= 0){
                if(a.charAt(lengthofa) == '1'){
                    if(flag == 1){
                        str = '0' + str;
                        lengthofa--;
                    }
                    else{
                        str = '1' + str;
                        lengthofa--;
                    }
                }
                else{
                    if(flag == 1){
                        str = '1' + str;
                        flag = 0;
                        lengthofa--;
                    }
                    else{
                        str = '0' + str;
                        lengthofa--;
                    }
                }
            }
        }
        if(lengthofb >= 0){
            while(lengthofb >= 0){
                if(b.charAt(lengthofb) == '1'){
                    if(flag == 1){
                        str = '0' + str;
                        lengthofb--;
                    }
                    else{
                        str = '1' + str;
                        lengthofb--;
                    }
                }
                else{
                    if(flag == 1){
                        str = '1' + str;
                        flag = 0;
                        lengthofb--;
                    }
                    else{
                        str = '0' + str;
                        lengthofb--;
                    }
                }
            }
        }
        if(flag == 1)
            str = '1' + str;
        return str;
    }

    public static String addBinary2(String a, String b){
        int m = BinaryToDec(a) + BinaryToDec(b);
        String s = DecToBinary(m);
        return s;
    }

    public static int BinaryToDec(String s){
        int length = s.length() - 1;
        double sum = 0;
        for(int i = 0;i < s.length();i++){
            sum += (s.charAt(i) - '0') * Math.pow(2,length);
            length--;
        }
        return (int)sum;
    }

    public static String DecToBinary(int n){
        if(n == 0)
            return "0";
        String s = "";
        while(n != 0){
            int m = n % 2;
            s = m + s;
            n = n / 2;
        }
        return s;
    }
}
