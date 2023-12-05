package Leetcode;

public class leetcode393 {
    public static void main(String[] args) {
        int[] data = {237};
        System.out.print(validUtf8(data));
    }
    public static boolean validUtf8(int[] data) {
        int i = 0;
        while(i < data.length){
            String s = binary(data[i]);
            switch(s.charAt(0)){
                case '0':i++;continue;
            }
            switch(s.substring(0,3)){
                case "110":{
                    if(i + 1 >= data.length)
                        return false;
                    String str = binary(data[i + 1]);
                    if(!str.substring(0,2).equals("10"))
                        return false;
                    i = i + 2;
                    continue;
                }
            }
            switch(s.substring(0,4)){
                case "1110":{
                    if(i + 2 >= data.length)
                        return false;
                    for(int k = i + 1;k < i + 3;k++){
                        String str = binary(data[k]);
                        if(!str.substring(0,2).equals("10"))
                            return false;
                    }
                    i = i + 3;
                    continue;
                }
            }
            switch(s.substring(0,5)){
                case "11110":{
                    if(i + 3 >= data.length)
                        return false;
                    for(int k = i + 1;k < i + 4;k++){
                        String str = binary(data[k]);
                        if(!str.substring(0,2).equals("10"))
                            return false;
                    }
                    i = i + 4;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
    public static String binary(int n){
        String s = "";
        while(n > 0){
            int m = n % 2;
            s = m + s;
            n = n / 2;
        }
        while(s.length() < 8){
            s = "0" + s;
        }
        return s;
    }
}
