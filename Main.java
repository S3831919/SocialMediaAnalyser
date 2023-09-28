import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
					continue;
					
				// Delete a social media post
				case 2:
					continue; 
				
				// retrieve a social media post
				case 3:

				for(int i = 0; i < postList.size(); i++) {
					System.out.println(i + ". " + postList.get(i).getPostID() + " | " +postList.get(i).getPostContent() );
				}
				
				System.out.print("Please select a post> ");
				try {
					userSelection = input.nextInt();
				}
				catch (InputMismatchException e ) {
					System.out.print(e);
				}
				
				while ((userSelection >= postList.size() || userSelection < 0)) {
				//prompt the user for a post selection
				media.wrongValue();
				System.out.print("Please select a post> ");
				
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