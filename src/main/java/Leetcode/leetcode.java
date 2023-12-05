package Leetcode;

public class leetcode {
    public static void main(String[] args) {
        System.out.print(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        int result = 0;
        int i = 0;
        while(i < s.length()){
            switch(s.charAt(i)){
                case 'C': {
                    if(i != s.length() - 1){
                        if (s.charAt(i + 1) == 'M') {
                            result += 900;
                            i = i + 2;
                            break;
                        }
                        if (s.charAt(i + 1) == 'D'){
                            i = i + 2;
                            result += 400;
                            break;
                        }
                    }
                    i++;
                    result += 100;
                    break;
                }
                case 'X': {
                    if(i != s.length() - 1){
                        if (s.charAt(i + 1) == 'C') {
                            result += 90;
                            i = i + 2;
                            break;
                        }
                        if (s.charAt(i + 1) == 'L'){
                            i = i + 2;
                            result += 40;
                            break;
                        }
                    }
                    i++;
                    result += 10;
                    break;
                }
                case 'I': {
                    if(i != s.length() - 1){
                        if (s.charAt(i + 1) == 'X') {
                            result += 9;
                            i = i + 2;
                            break;
                        }
                        if (s.charAt(i + 1) == 'V') {
                            i = i + 2;
                            result += 4;
                            break;
                        }
                    }
                    i++;
                    result += 1;
                    break;
                }
                case 'M': result += 1000;i++;break;
                case 'D': result += 500;i++;break;
                case 'L': result += 50;i++;break;
                case 'V': result += 5;i++;break;
            }
        }
        return result;
    }
}
