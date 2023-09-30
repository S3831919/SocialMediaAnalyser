import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		//CSV Column values 
		int ID = 0;
		int content = 1;
		int author = 2; 
		int likes = 3; 
		int shares = 4; 
		int time = 5; 
		int type = 6; 
		
		Boolean validation = false; 
		int userSelection = 0; 
		List<String[]> list = new ArrayList<>();
		
		Boolean exceptionCheck = false;
		
		LocalDateTime timeStamp = LocalDateTime.now();
		
		System.out.println(timeStamp);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		System.out.println(formatter);
		String formattedTimestamp = timeStamp.format(formatter);
		
		System.out.println(formattedTimestamp);
		
		//Scanner to take user input
		Scanner input = new Scanner(System.in);
		
		//creates the array list that contains the Posts
		ArrayList<Post> postList = new ArrayList<Post>();
		
		//create object for menu methods		
		MediaAnalyser media = new MediaAnalyser(); 
		
		//create a new post 
		Post post = new Post(0, "", "", 0, 0, "",0);
		
		//takes in CSV file 
		try (Scanner scanner = new Scanner(new File("posts.csv"))) {
			
			//ignores the heading row 
			if(scanner.hasNextLine()) {
				scanner.nextLine();
			}
			
			 while (scanner.hasNextLine()) {
				 String line = scanner.nextLine();
				 String[] values = line.split(",");
				 list.add(values);
			 }
		}
		catch (FileNotFoundException e) {
			System.out.print(e);
		}
		
		// takes csv data and populates the "Post" ArrayList
		for (String[] row : list) {
			
			post = new Post(0, "", "", 0, 0, "",0);
			
			postList.add(post);
			
			post.setPostID(Integer.parseInt(row[ID]));
			
			post.setPostContent(row[content]);
			
			post.setPostAuthor(row[author]);
			
			post.setPostLikes(Integer.parseInt(row[likes]));

			post.setPostShares(Integer.parseInt(row[shares]));
			
			post.setPostTimeStamp(row[time]);
			
			post.setPostType(Integer.parseInt(row[type]));
			
		}
		
		//main switch statement 
		while (!validation) {
			
			// prints the menu to the user
			media.showMenu();

			try {
				userSelection = input.nextInt();
			}
			catch (InputMismatchException e){
				media.wrongDataTypeError();
			}
			
			// Check if number selection is valid 1-7
			if (userSelection >= 1 && userSelection <= 7) {
				
				// Where the user selection is decided
				switch (userSelection) {

				// Add social media post
				case 1:

					//create new Post object 
					post = new Post(0, "", "", 0, 0, "",0);
					postList.add(post);
					
				// repeatedly asks user for number of shares until they add correct data type 
				do {
					
					System.out.println("Please enter the Post ID: ");
					exceptionCheck = false;
					try {
						userSelection = input.nextInt();
					}
					catch (InputMismatchException e){
						media.wrongDataTypeError();
						exceptionCheck = true;
						
						//consumes data 
						input.nextLine();
					}
					
					for(int i = 0; i < postList.size(); i++) {
						int testID = postList.get(i).getPostID();
						if(testID == userSelection) {
							media.alreadyUsed();
							exceptionCheck = true; 
							if (exceptionCheck == true) {
							break; 
							} 
						}
					}
					post.setPostID(userSelection);
					
				} while (post.getPostID() < 0 || exceptionCheck == true);		
							
				System.out.println("Please enter the Post Content: ");
				post.setPostContent(input.next());
			
				System.out.println("Please enter the Post Author: ");
				post.setPostAuthor(input.next());
		
				// repeatedly asks user for number of likes until they add correct data type 
				do {
					System.out.println("Please enter the number of Post likes: ");
					exceptionCheck = false;
					try {
						post.setPostLikes(input.nextInt());
					}
					catch (InputMismatchException e){
						media.wrongDataTypeError();
						exceptionCheck = true;
						
						//consumes data 
						input.nextLine();
					}
					
				} while (post.getPostLikes() < 0 || exceptionCheck == true);
	
				
				// repeatedly asks user for number of shares until they add correct data type 
				do {
					System.out.println("Please enter the number of Post shares: ");
					exceptionCheck = false;
					try {
						post.setPostShares(input.nextInt());
					}
					catch (InputMismatchException e){
						media.wrongDataTypeError();
						exceptionCheck = true;
						
						//consumes data 
						input.nextLine();
					}
				} while (post.getPostShares() < 0 || exceptionCheck == true);
		
	
				
				// repeatedly asks user for time until they add correct format 
				do {
					System.out.println("Please enter the Post TimeStamp (dd-MM-yyyy HH:mm): ");
					exceptionCheck = false;
					String timeInput = input.next();
					
//					String regexPattern = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4} (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$";
//					Pattern pattern = Pattern.compile(regexPattern);
//					
//						
//					Matcher matcher = pattern.matcher(timeInput);
//					
//					System.out.print(matcher);
//					
//					if(matcher.matches()) {
//						post.setPostTimeStamp(timeInput);
//                  }
					
					if(timeInput.equals(timeInput) ) {
						post.setPostTimeStamp(formattedTimestamp);
					}
					else {
						media.wrongTime();
						exceptionCheck = true; 
					}
					
				} while (post.getPostTimeStamp() == null || exceptionCheck == true);

				
				System.out.println("Please enter the Post Type - (0) for a new Post and Post (ID) for Reply to a post: ");
				post.setPostType(input.nextInt());
		
				// Delete a social media post
				case 2:
					continue; 
				
				// retrieve a social media post
				case 3:

				for(int i = 0; i < postList.size(); i++) {
					System.out.println(i + ". " + postList.get(i).getPostID() + " | " +postList.get(i).getPostContent() );
				}
				
				System.out.println("Please select a post: ");
				try {
					userSelection = input.nextInt();
				}
				catch (InputMismatchException e ) {
					System.out.print(e);
				}
				
				while ((userSelection >= postList.size() || userSelection < 0)) {
				//prompt the user for a post selection
				media.wrongValue();
				System.out.println("Please select a post> ");
				
				try {
					userSelection = input.nextInt();
				}
				catch (InputMismatchException e ) {
					System.out.print(e);
				}
	
			}
			
				System.out.println("\n" + postList.get(userSelection).toString());
				
				// Retrieve all replies of a particular social media post
				case 4:
					continue;
					
				
				// Retrieve the top N post and replies with the most likes
				case 5:
					continue;
					
					
				// Retrieve the top N post and replies with most shares
				case 6:
					continue;
					
				
				// Exit Program
				case 7:
					//terminate the program 
					System.out.println("Thank you for using the Social Media Analyser\n \n**Exiting program** \n ");
					validation = true;
					break;
				
				}
			
			}
			else if(userSelection < 1 || userSelection > 7){
				media.wrongValue();
			}

		}

	}
	
}