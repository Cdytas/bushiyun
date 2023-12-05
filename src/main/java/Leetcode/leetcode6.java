package Leetcode;

public class leetcode6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,4));
    }
    public static String convert(String s, int numRows) {
        int row = numRows;
        int column = s.length() / 2 + 1;
        char a[][] = new char[row][column] ;
        int i,j;
        int index = 0;
        StringBuilder build = new StringBuilder();
        if(numRows == 1)
            return s;
        while(index < s.length()) {
            for (j = 0; j < column; j++) {
                if (j % (row - 1) == 0) {
                    for (i = 0; i < row; i++) {
                        if(index >= s.length())
                            break;;
                        a[i][j] = s.charAt(index++);
                    }
                }
                else {
                    for (i = row - 2; i > 0; i--) {
                        if(index >= s.length())
                            break;;
                        a[i][j++] = s.charAt(index++);
                    }
                    j--;
                }
                if(index >= s.length())
                    break;;
            }
        }
        for(i = 0;i < row;i++){
            for(j = 0;j < column;j++){
                if((int)a[i][j] != 0)
                    build.append(a[i][j]);
            }
        }
        return build.toString();
    }
}
