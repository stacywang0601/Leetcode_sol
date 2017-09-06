package B09_06;

import java.util.HashMap;
import java.util.Random;

/***
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such as
 * http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your
 * encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny
 * URL and the tiny URL can be decoded to the original URL.
 */
public class Leet535EncodeandDecodeTinyURL {

	String	                alphabet	= "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	HashMap<String, String>	map	     = new HashMap<>();
	Random	                rand	 = new Random();
	String	                key	     = getRand();

	/**
	 * The number of URLs that can be encoded is quite large, nearly of the order (10+26*2)^6
	 * ​
	 * The length is fixed to 6 units, significant reduction for very large URLs.
	 * 
	 * The performance of this scheme is quite good, due to a very less probability of repeated same
	 * codes generated.
	 * 
	 * We can increase the number of encodings possible as well, by increasing the length of the
	 * encoded strings. Thus, there exists a tradeoff between the length of the code and the number
	 * of encodings possible.
	 * 
	 * Predicting the encoding isn't possible in this scheme since random numbers are used.
	 */
	public String getRand() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(alphabet.charAt(rand.nextInt(62)));
		}
		return sb.toString();
	}

	public String encode(String longUrl) {
		while (map.containsKey(key)) {
			key = getRand();
		}
		map.put(key, longUrl);
		return "http://tinyurl.com/" + key;
	}

	public String decode(String shortUrl) {
		return map.get(shortUrl.replace("http://tinyurl.com/", ""));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));