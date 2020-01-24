package class51_25_1_2019;

public class kmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String p = "kasd";
		String s = "adsnasndkasdubasckasdnsda";
		patternMatching(s, p);

	}

	private static void patternMatching(String s, String p) {

		int[] lps = preprocess(p);
		int i = 0;
		int j = 0;

		while (i < s.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
				if (j == p.length()) {
					System.out.println(p + "found at" + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

	}

	private static int[] preprocess(String p) {

		int[] lps = new int[p.length()];
		int i = 1;
		int len = 0;

		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(len)) {

				len++;
				lps[i] = len;
				i++;

			} else {
				if (len > 0) {
					len = lps[len - 1];
				} else {
					i++;
				}
			}
		}
		return lps;

	}

}
