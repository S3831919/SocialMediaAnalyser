import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;

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
		
		String userEntry = ""; 
		
		Boolean validation = false; 
		int userSelection = 0; 
		List<String[]> list = new ArrayList<>();
		
		Boolean exceptionCheck = false;
		
		LocalDateTime timeStamp = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formattedTimestamp = timeStamp.format(formatter);
		
		//Scanner to take user input
		Scanner input = new Scanner(System.in);
		
		//creates the array list that contains the Posts
		ArrayList<Post> postList = new ArrayList<Post>();
		
		//creates the array list that contains the Reply
		ArrayList<Reply> replyList = new ArrayList<Reply>();
		
		//create object for menu methods		
		MediaAnalyser media = new MediaAnalyser(); 
		
		//create a new post 
		Post post = new Post(0, "", "", 0, 0, "",0);
		
		//create a new reply 
		Reply reply = new Reply(0, "", "", 0, 0, "",0);
		
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
			reply = new Reply(0, "", "", 0, 0, "",0);
			
			postList.add(post);
			replyList.add(reply);
				
			post.setPostID(Integer.parseInt(row[ID]));
			reply.setPostID(Integer.parseInt(row[ID]));
				
			post.setPostContent(row[content]);
			reply.setPostContent(row[content]);
				
			post.setPostAuthor(row[author]);
			reply.setPostAuthor(row[author]);
			
			post.setPostLikes(Integer.parseInt(row[likes]));
			reply.setPostLikes(Integer.parseInt(row[likes]));

			post.setPostShares(Integer.parseInt(row[shares]));
			reply.setPostShares(Integer.parseInt(row[shares]));
			
			post.setPostTimeStamp(row[time]);
			reply.setPostTimeStamp(row[time]);
			
			post.setPostType(Integer.parseInt(row[type]));
			reply.setPostType(Integer.parseInt(row[type]));
			
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
				input.nextLine();
			}
			
			// Check if number selection is valid 1-7
			if (userSelection >= 1 && userSelection <= 7) {
				
				// Where the user selection is decided
				switch (userSelection) {

				// Add social media post
				case 1:

					//create new Post and Reply object 
					post = new Post(0, "", "", 0, 0, "",0);
					reply = new Reply(0, "", "", 0, 0, "",0);
					
					postList.add(post);
					replyList.add(reply);
					
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
				userEntry = input.next();
				post.setPostContent(userEntry);
				input.nextLine();
			
				System.out.println("Please enter the Post Author: ");
				userEntry = input.next();
				post.setPostAuthor(userEntry);
				input.nextLine();
		
				// repeatedly asks user for number of likes until they add correct data type 
				do {
					System.out.println("Please enter the number of Post likes: ");
					exceptionCheck = false;
					try {
						userSelection = input.nextInt();
						post.setPostLikes(userSelection);
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
						userSelection = input.nextInt();
						post.setPostShares(userSelection);
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
					input.nextLine();
					
//					String regexPattern = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4} (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$";
//					Pattern pattern = Pattern.compile(regexPattern);
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

				
				do {
				System.out.println("Please enter the Post Type - (0) for a new Post and Post (ID) for Reply to a post: ");
				try {
					userSelection = input.nextInt();
				}
				catch (InputMismatchException e) {
					media.wrongDataTypeError();
					input.nextLine();
				}
					post.setPostType(userSelection);
					
				if(userSelection == 0) {
					post.setPostType(userSelection);
				}
				
				// if post type is a reply, Reply ArrayList is updated 
				else if(userSelection == post.getPostID() && userSelection != 0) {
					
					reply.setPostType(userSelection);
					reply.setPostID(post.getPostID());
					reply.setPostContent(post.getPostContent());
					reply.setPostAuthor(post.getPostAuthor());
					reply.setPostLikes(post.getPostLikes());
					reply.setPostShares(post.getPostShares());
					reply.setPostTimeStamp(post.getTimeStamp());
					
				}
				
				}
				
				while(userSelection < 0 || userSelection > postList.size());
				
				input.nextLine();
				
				break; 

				// Delete a social media post
				case 2:
					
					//check if array list is empty
					if (postList.isEmpty()) {
						System.out.println("\n" + "**No posts available**" + "\n");
					} 
					else { //present items to delete to the user 
						do {	//loop until user enters a valid input 
						System.out.println("Which post would you like to remove?");
						for (int i = 0; i < postList.size(); i++) {
							if(postList.get(i) != null) {
								System.out.println(i + "." + " Post " + postList.get(i).getPostID());
							}
						}
						
						System.out.print(">");
		
						try {
						// takes users selection
						userSelection = input.nextInt();
						}
						catch (InputMismatchException e) {
							media.wrongDataTypeError();
							userSelection = -1; 
							input.nextLine();
						}
						
						if(userSelection >= 0 && userSelection < postList.size()) {
							postList.remove(userSelection); 
							replyList.remove(userSelection); 
							System.out.println("\n**Post " + userSelection + " Deleted**\n");
						}
						else {
							media.wrongValue();
						}
						}
						while(userSelection <= 0 || userSelection > postList.size());
						
						break;
					}
				
				// retrieve a social media post
				case 3:

				for(int i = 0; i < postList.size(); i++) {
					if(postList.get(i).getPostType() == 0) {
					System.out.println(i + ". " + postList.get(i).getPostID() + " | " +postList.get(i).getPostContent() );
					}
				}
				
				System.out.println("Please select a post: ");
				try {
					userSelection = input.nextInt();
				}
				catch (InputMismatchException e ) {
					System.out.print(e);
					input.nextLine();
				}
				
				while ((userSelection >= postList.size() || userSelection < 0)) {
				//prompt the user for a post selection
				media.wrongValue();
				System.out.println("Please select a post> ");
				
				try {
					userSelection = input.nextInt();
				}
				catch (InputMismatchException e ) {
					media.wrongDataTypeError();
					input.nextLine();
				}
	
			}
			
				System.out.println("\n" + postList.get(userSelection).toString());
				
				break; 
				
				// Retrieve all replies of a particular social media post
				case 4:
					
					exceptionCheck = false;
					
					for(int i = 0; i < postList.size(); i++) {
						
						if(postList.get(i).getPostType() == 0) {
						System.out.println(i + ". " + postList.get(i).getPostID() + " | " + postList.get(i).getPostContent() );
						}
					}
					
					do {
				System.out.println("Please select a post: ");
				
					try {
						userSelection = input.nextInt();
					}
					catch (InputMismatchException e ) {
						media.wrongDataTypeError();
						input.nextLine();
					}
					
					if((userSelection > postList.size() || userSelection < 0)) {
						exceptionCheck = true; 
						media.wrongValue();
					}
					else {
							
					for(int i = 0; i < postList.size(); i++) {
						
					if(postList.get(i).getPostType() == replyList.get(userSelection).getPostID()) {	
						
						System.out.println(replyList.get(i).toString());
	
					}
					
				}

			}
					
			}while (exceptionCheck = false);

					break; 

				// Retrieve the top N post and replies with the most likes
				case 5:
					
					ArrayList<Post> orderLikes = new ArrayList<Post>();
					int topPostLikes = 0;
					
					for(int i = 0; i < postList.size(); i++) {
						
						if(postList.get(i).getPostLikes() > postList.get(topPostLikes).getPostLikes()) {
							topPostLikes = i;
							
							orderLikes.add(postList.get(i));
							
						}
						
					}

					Collections.sort(orderLikes, new PostLikesComparator());

					System.out.println("Please enter the number of top posts: ");
					
					try {
						userSelection = input.nextInt();
					}
					catch (InputMismatchException e ) {
						media.wrongDataTypeError();
						input.nextLine();
					}
					
					while(userSelection < 0 || userSelection > orderLikes.size()) {
						
						System.out.println("Please enter the number of top posts: ");
						
						try {
							userSelection = input.nextInt();
						}
						catch (InputMismatchException e ) {
							media.wrongDataTypeError();
							input.nextLine();
						}
				}
						
						for(int i = 0 ; i < userSelection ; i++) {
							System.out.print(orderLikes.get(i));
						}

					break; 
					
				// Retrieve the top N post and replies with most shares
				case 6:
					
					ArrayList<Post> orderShares = new ArrayList<Post>();
					int topPostShares = 0;
					
					for(int i = 0; i < postList.size(); i++) {
						
						if(postList.get(i).getPostShares() > postList.get(topPostShares).getPostShares()) {
							topPostLikes = i;
							
							orderShares.add(postList.get(i));

						}
						
					}

					Collections.sort(orderShares, new PostLikesComparator());

					System.out.println("Please enter the number of top posts: ");
					
					try {
						userSelection = input.nextInt();
					}
					catch (InputMismatchException e ) {
						media.wrongDataTypeError();
						input.nextLine();
					}
					
					while(userSelection < 0 || userSelection > orderShares.size()) {
						
						System.out.println("Please enter the number of top posts: ");
						
						try {
							userSelection = input.nextInt();
						}
						catch (InputMismatchException e ) {
							media.wrongDataTypeError();
							input.nextLine();
						}
				}

						for(int i = 0 ; i < userSelection ; i++) {
							System.out.print(orderShares.get(i));
						}

					break; 
					
				
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