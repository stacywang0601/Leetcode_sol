package B07_06;

public class Leet344ReverseString {

	/** 1-－StringBuffer(s) reverse toString */
	public String reverseString(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	public String reverseString2(String s) {
		char[] arr = s.toCharArray();
		int i = 0, j = arr.length - 1;
		while (i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return new String(arr);

	}

}
