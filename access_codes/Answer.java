import java.util.ArrayList;

public class Answer {
	public static int answer(String[] x) {

		ArrayList<String> distinctCodeslist = new ArrayList<String>();

		// for each access code
		for (String currentAccessCode : x) {
			// if the current access code both reversed and normal is not in the
			// distinct codes list add it
			if (!distinctCodeslist.contains(reverseOfString(currentAccessCode))
					&& !distinctCodeslist.contains(currentAccessCode)) {

				distinctCodeslist.add(currentAccessCode);
			}
		}
		// return the size of the list which reflects how many unique access
		// codes there are.
		return distinctCodeslist.size();

	}

	
	// Reverse the String passed to this method.
	private static String reverseOfString(String originalString) {

		return new StringBuilder(originalString).reverse().toString();
	}
	
	public static void main(String[] args) {
		String [] x = {"x", "y", "xy", "yy", "", "yx"};
		System.out.print(answer(x));
	}
	
	
	
}