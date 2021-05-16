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
	public void validReviewersTest() {
		List<Researcher> joao =Arrays.asList(database.getResearcherById(1));
		List<Researcher> ana =Arrays.asList(database.getResearcherById(2));
		List<Researcher> suzana =Arrays.asList(database.getResearcherById(7));
		List<Researcher> natasha =Arrays.asList(database.getResearcherById(8));
		Article articleA = database.getArticleById(1);
		Article articleB = database.getArticleById(7);
		assertTrue(articleA.validReviewers(joao).isEmpty());  //Jo�o n�o pode avaliar o pr�prio artigo
	  	assertFalse(articleA.validReviewers(ana).isEmpty());  
		assertTrue(articleA.validReviewers(suzana).isEmpty());
		assertTrue(articleA.validReviewers(natasha).isEmpty());
		assertFalse(articleB.validReviewers(joao).isEmpty());
	}
	
	@Test
	public void gradesTest() {
		
		Article article2 = database.getArticleById(2);
		assertEquals(article2.AverageGrade(), 2,5);
		
		Article article3 = database.getArticleById(3);
		assertTrue(article3.AverageGrade() == 0);
		
		Article article4 = database.getArticleById(4);
		assertEquals(article4.AverageGrade(), 0,5);
		
		Article article5 = database.getArticleById(5);
		assertTrue(article5.AverageGrade() == -3);
		
		Article article6 = database.getArticleById(6);
		assertEquals(article6.AverageGrade(), -0,5);		
		
		
	}

}
