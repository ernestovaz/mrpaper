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


	public void testArticle1() {
		Article a1 = database.getArticleById(1);
		assertTrue(a1.getReviews().size() == 2);
		assertNull(a1.getReviews().get(1).getRating());
	}
	
	@Test
	public void testConference() {
		
		Conference cini1 = database.getConferenceByInitials("ICSE");
		Conference cid1 = database.getConferenceById(1);
		
		Conference fse = database.getConferenceByInitials("FSE");
		//assertTrue(fse.)
		
		assertTrue(cini1 == cid1);
		assertTrue(cini1.getInitials() == "ICSE");
		
		Conference ci = database.getConferenceByInitials("aasdasdasdasdsdas");
		assertTrue(ci == null);
		
		Conference cini2 = database.getConferenceByInitials("FSE");
		Conference cid2 = database.getConferenceById(2);
		
		assertTrue(cid2.getId() == 2);
		assertTrue(cid2.getId() == cini2.getId());		
		
	}

}
