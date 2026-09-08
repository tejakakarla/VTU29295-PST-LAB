PROBLEM STATEMENT:
	/*Lapindrome is defined as a string which when split in the middle, gives two halves having the same characters and same frequency of each character. If there are odd number of characters in the string, we ignore the middle character and check for lapindrome. For example gaga is a lapindrome, since the two halves ga and ga have the same characters with same frequency. Also, abccab, rotor and xyzxy are a few examples of lapindromes. Note that abbaab is NOT a lapindrome. The two halves contain the same characters but their frequencies do not match.
Your task is simple. Given a string, you need to tell if it is a lapindrome.

Input:
First line of input contains a single integer T, the number of test cases.
Each test is a single line containing a string S composed of only lowercase English alphabet.
Output:
For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.
Constraints:
1 ≤ T ≤ 100
2 ≤ |S| ≤ 1000, where |S| denotes the length of S
Sample 1:
Input
Output
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
YES
NO
YES
YES
NO
NO
Did you like the problem statement?
138 users found this helpful
*/


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
