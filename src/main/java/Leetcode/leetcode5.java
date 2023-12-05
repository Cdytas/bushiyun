package Leetcode;
public class leetcode5 {
    public static void main(String[] args) {
        String s = "acbde" ;
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s){
        int i , j,k,h;
        int []a = new int[s.length() - 1];
        if(s.length() == 1){
            return s;
        }
        for(i = 0;i < s.length() - 1;i++){
            for(j = s.length() - 1;j >= i;j--) {
                k = i;
                h = j;
                while (k < h){
                    if (s.charAt(k) == s.charAt(h)) {
                        k++;
                        h--;
                    } else
                        break;
                }
                if (k >= h){
                    a[i] = j - i + 1;
                    break;
                }
            }
        }
        int max = a[0];
        int index = 0;
        for(i = 1;i < s.length() - 1;i++){
            if(a[i] > max){
                max = a[i];
                index = i;
            }
        }
        return s.substring(index,max+index);
    }
}
