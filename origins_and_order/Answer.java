
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Answer {
	private static String Answer;
	public static void main(String[] args) {
		System.out.print(answer(1,1,1));
	}
	public static String answer(int x, int y, int z) {
		//If the numbers are all the same and less than 12 
		//there can only be one valid date. 
		if (x == z && x == y && y == z && x <= 12 && x >= 1) {
			validDate(x + "/" + y + "/" + z);
			return Answer;
		}
		//if two of the numbers are larger than 12 there is the possibility of only a single valid date.
		if (x > 12 && z > 12 || y > 12 && z > 12 || x > 12 && y > 12) {
			int[] array = new int[3];
			array[0] = x;
			array[1] = y;
			array[2] = z;
			//Sort the integers so that we have a valid month.
			Arrays.sort(array);
			int counter = 0;
			List<String> datePossibilitylist = new ArrayList<String>();
			// if the two larger numbers are not the same add both possibilities to the list. 
			if (array[1] != array[2]) {
				datePossibilitylist.add(array[0] + "/" + array[1] + "/"
						+ array[2]);
				datePossibilitylist.add(array[0] + "/" + array[2] + "/"
						+ array[1]);
			} else {
				//if two of the numbers are the same add only once
				datePossibilitylist.add(array[0] + "/" + array[1] + "/"
						+ array[2]);
			}
			//for each possible date check if the date is valid.
			for (String i : datePossibilitylist) {
				if (validDate(i)) {
					counter++;
				}
			}
			//if there is only one valid date return it as a String. 
			if (counter == 1) {
				return Answer;
				//If there is more than one valid date return ambiguous.
			} else if (counter > 1 || counter < 1) {
				return "Ambiguous";
			}

		}
		//return Ambiguous if there are two or more numbers <12 
		return "Ambiguous";
	}

	//Format the date into the specified format and set the answer to this value. 
	private static void formatDate(Date i) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		formatter.setLenient(false);
		Answer = formatter.format(i);
	}

	//check if the date is valid as per the format.
	//if its valid call formatDate and return true. 
	private static boolean validDate(String date) {
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		formatter.setLenient(false);
		Date tryDate = null; 
			try
		{
			tryDate = formatter.parse(date);
		}catch (ParseException e) {
			return false;
		}
		formatDate(tryDate);
		return true; 
		
	}
}