public class Post {

	private int postID = 0;
	private String postContent = "";
	private String postAuthor = "";
	private int postLikes = 0;
	private int postShares = 0; 
	private String timeStamp = ""; 
	private int postType = 0;

	// Constructor 
	public Post(int postID, String postContent, String postAuthor, int postLikes, int postShares, String postTimeStamp, int postType) {
				
		this.postID = postID;
		this.postContent = postContent; 
		this.postAuthor = postAuthor;
		this.postShares = postShares; 
		this.timeStamp = postTimeStamp;
		this.postType = postType; 
		
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public Post() {
		
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}

	public int getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(int postLikes) {
		this.postLikes = postLikes;
	}

	public int getPostShares() {
		return postShares;
	}

	public void setPostShares(int postShares) {
		this.postShares = postShares;
	}

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getPostTimeStamp() {
		return timeStamp;
	}
	public void setPostTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	// To string method used to print out all variables 
    @Override
    public String toString() {
        return postID + " | " + postContent + " | " + postAuthor + " | " + "Post Likes: " + postLikes + " | " + "Post Shares: " + postShares +  
        		  " | " + "Post TimeStamp: "  + timeStamp + "\n"; 
    }
    
}


