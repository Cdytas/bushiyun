package Leetcode;

public class leetcode792 {
    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String []words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.print(numMatchingSubseq(s,words));
    }
    public static  int numMatchingSubseq(String s, String[] words) {
        int i,j ,k;
        int count = 0;
        for(i = 0;i < words.length;i++){
            j = 0;
            k = 0;
            while(j < s.length() && k < words[i].length()){
                if(words[i].charAt(k) == s.charAt(j)){
                    j++;
                    k++;
                }
                else{
                    j++;
                }
            }
            if(j == s.length()){
                if(k == words[i].length()){
                    count++;
                    continue;
                }
                else
                    continue;
            }
            if(k == words[i].length())
                count++;
        }
        return count;
    }

}
