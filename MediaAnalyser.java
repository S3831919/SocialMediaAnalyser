
public class MediaAnalyser {

	public MediaAnalyser() {
	
	}

	// method used to print the user menu
	public static void showMenu() {

		String[] menuArray = { "Welcome to Social Media Analyser!",
				"---------------------------------------------------------", "> Select from main menu",
				"---------------------------------------------------------", "1. Add a social media post",
				"2. Delete a social media post", "3. Retrieve a social media post",
				"4. Retrieve all replies of a particular social media post",
				"5. Retrieve the top N post and replies with the most likes",
				"6. Retrieve the top N post and replies with most shares", "7. Exit", "Please Select: ", };

		// loop that iterates through the list of array items
		for (int i = 0; i < menuArray.length; i++) {

			// Outputs each item of the array to console green and bold text
			System.out.printf("%s", menuArray[i] + "\n");

		}

	}
	
	// prints error if wrong data type is used 
	public static void wrongDataTypeError() {
		System.out.println("\n**Invalid data type - Please enter an Integer**\n");
	}
	
	public static void wrongValue() {
		System.out.println("\n**Invalid value - Please enter an number from the list**\n");
	}
	
}