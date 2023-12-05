package Leetcode;

public class leetcode97 {
    public static void main(String[] args) {

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1 + s2).equals(s3) || (s2 + s1).equals(s3))
            return true;
        if(s1.length() + s2.length() != s3.length())
            return false;
        return isinterleave(0,0,0,s1,s2,s3);
    }

    public static boolean isinterleave(int i,int j,int k,String s1,String s2,String s3){
        if(i >= s1.length() || j >= s2.length() || k >= s3.length())
            return false;
        if(i == s1.length() - 1 &&  j == s2.length() - 1 && k == s3.length() - 1)
        if(s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)){
            return isinterleave(i + 1,j,k + 1,s1,s2,s3);
           /* return isinterleave(i,j + 1,k + 1,s1,s2,s3);*/
        }
        else if(s3.charAt(k) == s1.charAt(i)){
            return isinterleave(i + 1,j,k + 1,s1,s2,s3);
        }
        else if(s3.charAt(k) == s2.charAt(j)){
            return isinterleave(i,j + 1,k + 1,s1,s2,s3);
        }
        else
            return false;
        return true;
    }
}