import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SocialMediaTest {
	
    private Post post;
    private Reply reply;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
    @Before
    public void setUp() {
        // Initialize Post and Reply objects for testing
        post = new Post(20582, "Come and meet us at Building 14 of RMIT.", "SD2C45", 10, 24, "12/05/2023  10:10:00", 0);
        //reply = new Reply(1, "Reply Content", "Author", 5, 3, "01-01-2023 12:30", 1);
    }
    
    @Test
    public void testPostLikes() {
        // Test if postLikes are set and retrieved correctly
        assertEquals(10, post.getPostLikes());
    }

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
    @Test
    public void testPostListAddition() {
        // Test if a Post is correctly added to the PostList ArrayList
        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post);
        assertEquals(1, postList.size());
    }

}
