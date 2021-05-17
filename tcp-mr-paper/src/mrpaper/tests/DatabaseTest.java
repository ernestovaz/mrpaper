package mrpaper.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Conference;
import mrpaper.data.Database;

public class DatabaseTest {
	
	Database database;

	@Before
	public void setUp() throws Exception {
		database = new Database(true);
	}
	
	/**
	 * Os testes abaixo consideram como corretos apenas os dados 
	 * inicias descritos na especifica��o do trabalho pr�tico
	 */

	@Test
	public void testArticle1() {
		Article a1 = database.getArticleById(1);
		assertTrue(a1.getReviews().size() == 2);
		assertNull(a1.getReviews().get(1).getRating());
	}
	
	@Test
	public void testConference() {
		
		Conference cini = database.getConferenceByInitials("FSE");
		Conference cid = database.getConferenceById(2);
		
		assertTrue(cid.getId() == 2);
		assertTrue(cid.getId() == cini.getId());
		
		
	}

}
