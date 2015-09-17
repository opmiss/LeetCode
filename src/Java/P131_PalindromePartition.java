package Java;

public class P131_PalindromePartition {
	/*
	 * Given a string s, partition s such that every substring of the partition is a palindrome.
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * For example, given s = "aab",
	 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 */
	public int minCut(String s) {
		int[] cut = new int[s.length()];
		for (int i = 0; i < s.length(); i++)
			cut[i] = i;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; i - j >= 0 && i + j < s.length()
					&& s.charAt(i - j) == s.charAt(i + j); j++) {
				if (i == j)
					cut[i + j] = 0;
				else
					cut[i + j] = Math.min(cut[i + j], cut[i - j - 1] + 1);
			}
			for (int j = 0; i - j >= 0 && i + j < s.length() - 1
					&& s.charAt(i - j) == s.charAt(i + j + 1); j++) {
				if (i == j)
					cut[i + j + 1] = 0;
				else
					cut[i + j + 1] = Math.min(cut[i + j + 1],
							cut[i - j - 1] + 1);
			}
		}
		return cut[s.length() - 1];
	}
}
