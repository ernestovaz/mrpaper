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
	 * inicias descritos na especificaï¿½ï¿½o do trabalho prï¿½tico
	 */

	@Test
	public void validReviewersTest() {
		List<Researcher> joao =Arrays.asList(database.getResearcherById(1));
		List<Researcher> ana =Arrays.asList(database.getResearcherById(2));
		List<Researcher> suzana =Arrays.asList(database.getResearcherById(7));
		List<Researcher> natasha =Arrays.asList(database.getResearcherById(8));
		Article articleA = database.getArticleById(1);
		Article articleB = database.getArticleById(7);
		assertTrue(articleA.validReviewers(joao).isEmpty());  //João não pode avaliar o próprio artigo
	  	assertFalse(articleA.validReviewers(ana).isEmpty());  
		assertTrue(articleA.validReviewers(suzana).isEmpty());
		assertTrue(articleA.validReviewers(natasha).isEmpty());
		assertFalse(articleB.validReviewers(joao).isEmpty());
	}

}
