package Leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class leetcode3 
{
	public static void main(String[] args) 
	  {
		  System.out.print(lengthOfLongestSubstring("tmmzuxt"));
	  }

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		Map<Character, Integer> memo = new HashMap<>();
		int[] dp = new int[n];
		dp[0] = 1; //这表示只含有一个字符时，答案为1
		memo.put(s.charAt(0), 0);
		int res = 1;
		for (int i = 1; i < n; i++) {
			char c = s.charAt(i);
			if (!memo.containsKey(c)) {
				dp[i] = dp[i - 1] + 1;
			}
			else {
				int index = memo.get(c);
				if (index > i - dp[i - 1]) {
					dp[i] = i - index;
				}
				else {
					dp[i] = dp[i - 1] + 1;
				}
			}
			memo.put(c, i);
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
