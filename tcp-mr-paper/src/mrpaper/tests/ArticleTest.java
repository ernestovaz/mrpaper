package mrpaper.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;
import mrpaper.data.Database;

public class ArticleTest {
	
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
		Researcher r1 = database.getResearcherById(1);
		Researcher r2 = database.getResearcherById(2);
		Researcher r3 = database.getResearcherById(3);
		Article a1 = database.getArticleById(1);
		Article a2 = database.getArticleById(2);
		List<Researcher> l1 = Arrays.asList(r1,r2,r3);
		List<Researcher> t1 = Arrays.asList(r2);
		assertTrue(t1 == a1.validReviewers(l1));
	}

}
