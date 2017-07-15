package B07_14;

public class Leet514FreedomTrail {
	public int findRotateSteps(String ring, String key) {
		int ringLen = ring.length();
		int keyLen = key.length();
		int res = Integer.MAX_VALUE;
		int[][] dp = new int[keyLen][ringLen];

		for (int i = 0; i < keyLen; i++) {
			for (int j = 0; j < ringLen; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				if (key.charAt(i) == ring.charAt(j)) {
					// when i == 0,it means the first char in key and it has no previous reslut
					if (i == 0) {
						int diff = Math.abs(i - j);
						int step = Math.min(diff, ringLen - diff);
						dp[i][j] = Math.min(dp[i][j], step + 1);
					} else {
						for (int k = 0; k < ringLen; k++) {
							if (dp[i - 1][k] != Integer.MAX_VALUE) {
								int diff = Math.abs(k - j);
								int step = Math.min(diff, ringLen - diff);
								dp[i][j] = Math.min(dp[i][j], step + 1 + dp[i - 1][k]);
							}
						}

					}
				}
			}
		}
		for (int j = 0; j < ringLen; j++) {
			res = Math.min(dp[keyLen - 1][j], res);
		}

		return res;
	}
}