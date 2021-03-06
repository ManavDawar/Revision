package class51_25_1_2019;


public class zalgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "kasd";
		String s = "adsnasndkasdubasckasdnsda";
		patternMatching(s, p);

	}

	public static void patternMatching(String s, String p) {
		String con = p + "$" + s;
		Integer[] zarr = preprocess(con);

		for (int i = 1; i < zarr.length; i++) {
			if (zarr[i] == p.length()) {
				System.out.println(p + "found at" + (i - p.length() - 1));
			}
		}
	}

	private static Integer[] preprocess(String con) {
		Integer[] z = new Integer[con.length()];

		int l = 0;
		int r = 0;

		for (int i = 1; i < z.length; i++) {
			if (i > r) {
				l = i;
				r = i;
				while (r < con.length() && con.charAt(r) == con.charAt(r - l)) {
					r++;
				}
				r--;
				z[i] = r - l + 1;
			} else {

				int k = i - l;
				if (z[k] < r - i + 1) {
					z[i] = z[k];
				} else {
					l = i;
					while (r < con.length() && con.charAt(r) == con.charAt(r - l)) {
						r++;
					}
					r--;
					z[i] = r - l + 1;
				}
			}

		}

		return z;
	}

}
