package mrpaper.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mrpaper.business.domain.Article;
import mrpaper.data.Database;

public class DatabaseTest {
	
	Database database;

	@Before
	public void setUp() throws Exception {
		database = new Database(true);
	}
	
	/**
	 * Os testes abaixo consideram como corretos apenas os dados 
	 * inicias descritos na especificação do trabalho prático
	 */

	@Test
	public void testArticle1() {
		Article a1 = database.getArticleById(1);
		assertTrue(a1.getReviews().size() == 2);
		assertNull(a1.getReviews().get(1).getRating());
	}

}
