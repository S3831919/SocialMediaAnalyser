public class Reply extends Post{

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(int postID, String postContent, String postAuthor, int postLikes, int postShares, String postTimeStamp,
			int postType) {
		super(postID, postContent, postAuthor, postLikes, postShares, postTimeStamp, postType);
		// TODO Auto-generated constructor stub
	}

	public Reply(int postID, String postContent, String postAuthor, int postLikes, int postShares,
			String postTimeStamp) {
		super(postID, postContent, postAuthor, postLikes, postShares, postTimeStamp, postShares);
		// TODO Auto-generated constructor stub
	}
	
	// To string method used to print out all variables 
    @Override
    public String toString() {
        return "Reply ID: " + postID + " | " + "Reply Content: "  + postContent + " | "+ "Reply Author: " + postAuthor + " | " + "Reply Likes: " + postLikes + " | " + "Reply Shares: " + postShares +  
        		  " | " + "Reply TimeStamp: "  + timeStamp + " | " + "Main Post ID: " + postType + "\n"; 
    }
	
}