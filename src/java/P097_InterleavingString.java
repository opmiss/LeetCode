package java;

public class P097_InterleavingString {
	/*
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	 * For example,
	 * Given:
	 * s1 = "aabcc",
	 * s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true.
	 * When s3 = "aadbbbaccc", return false.
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length(), l2 = s2.length();
		if (l1 + l2 != s3.length())
			return false;
		if (l2 == 0) {
			if (s1.equals(s3))
				return true;
			else
				return false;
		}
		boolean[] visit = new boolean[l2 + 1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 && j == 0)
					visit[j] = true;
				else if (i == 0) {
					if (s3.charAt(j - 1) == s2.charAt(j - 1))
						visit[j] = visit[j - 1];
				} else if (j > 0) {
					boolean b1 = (s3.charAt(i + j - 1) == s1.charAt(i - 1))
							&& visit[j];
					boolean b2 = (s3.charAt(i + j - 1) == s2.charAt(j - 1))
							&& visit[j - 1];
					visit[j] = b1 || b2;
				}
			}
		}
		return visit[l2];
	}

}
