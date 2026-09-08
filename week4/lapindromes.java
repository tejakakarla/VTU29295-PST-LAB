import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			int t = sc.nextInt();
			while (t-- > 0) {
				String s = sc.next();
				if (isLapindrome(s)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		sc.close();
	}

	private static boolean isLapindrome(String s) {
		int n = s.length();
		int[] leftCount = new int[26];
		int[] rightCount = new int[26];
		
		int halfLength = n / 2;
		for (int i = 0; i < halfLength; i++) {
			leftCount[s.charAt(i) - 'a']++;
		}
		
		int rightStart = (n + 1) / 2;
		for (int i = rightStart; i < n; i++) {
			rightCount[s.charAt(i) - 'a']++;
		}
		
		return Arrays.equals(leftCount, rightCount);

	}
}
