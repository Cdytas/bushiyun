package Leetcode;

public class leetcode1061 {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "programs";
        String baseStr = "sourcecode";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));

    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] sup = new int[26];
        for (int i = 0; i < 26; i++) {
            sup[i] = -1;
        }
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            if (index1 == index2) {
                continue;
            }
            int big = Math.max(index1, index2);
            int min = Math.min(index1, index2);
            if (sup[big] != -1) {
                int index = sup[big];
                while (index > min) {
                    sup[big] = min;
                    index = sup[index];
                }
                if (sup[index] == -1) {
                    if(index > min) {
                        sup[index] = min;
                    }
                }
            }
            else {
                sup[big] = min;
            }
        }
        for (int i = 0; i < baseStr.length(); i++) {
            int index = baseStr.charAt(i) - 'a';
            while (sup[index] != -1) {
                index = sup[index];
            }
            build.append((char)(97 + index));
        }
        return build.toString();
    }


}
