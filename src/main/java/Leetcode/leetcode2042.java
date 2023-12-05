package Leetcode;

public class leetcode2042 {
    public static void main(String[] args) {
        String s = "hello world 5 x 5";
        System.out.print(areNumbersAscending(s));
    }

    public static boolean areNumbersAscending(String s) {
        int i = 0;
        boolean flag = false;
        int[] a = new int[100];
        int count = 0;
        String str = "";
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                if(flag == false)
                    i++;
                else{
                    flag = false;
                    a[count++] = Integer.parseInt(str);
                    str = "";
                    i++;
                }
            }
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                i++;
            }
            else{
                if(flag == false){
                    flag = true;
                    str += s.charAt(i);
                    i++;
                }
                else{
                    str += s.charAt(i);
                    i++;
                }
            }
            if(i == s.length() && str != "")
                a[count++] = Integer.parseInt(str);
        }
        for(i = 0;i < count - 1;i++){
            if(a[i] >= a[i + 1])
                return false;
        }
        return true;
    }
}
