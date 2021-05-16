package mrpaper.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Conference;
import mrpaper.business.domain.Researcher;
import mrpaper.data.Database;

public class ConferenceTest {
	
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
	public void sortReviewers() {
		Conference c2 = database.getConferenceById(2);
		Researcher joao =database.getResearcherById(1);
		Researcher ana =database.getResearcherById(2);
		Researcher manoel =database.getResearcherById(3);
		Researcher beatriz =database.getResearcherById(6);
		System.out.println(c2.getArticles());
		assertTrue(c2.sortReviewers(Arrays.asList(joao,ana,manoel))
					.containsAll(Arrays.asList(joao,ana,manoel)));
		assertTrue(c2.sortReviewers(Arrays.asList(joao,beatriz,manoel))
					.containsAll(Arrays.asList(joao,manoel,beatriz)));
		assertTrue(c2.sortReviewers(Arrays.asList(manoel,ana,joao))
					.containsAll(Arrays.asList(joao,ana,manoel)));
	}
	
	@Test
	public void selectedArticlesTests() {
	
		Conference Conferencia2 = database.getConferenceById(2);
		
		List <Article> Aprovados2 = Arrays.asList(database.getArticleById(2),database.getArticleById(3),database.getArticleById(4));
		List <Article> Rejeitados2 = Arrays.asList(database.getArticleById(5),database.getArticleById(6));
		List <Article> AprovadosSO = Arrays.asList(database.getArticleById(2),database.getArticleById(4),database.getArticleById(3));
		List <Article> Misto = Arrays.asList(database.getArticleById(5),database.getArticleById(4),database.getArticleById(2));
		
		//System.out.println(Conferencia2.getArticles().toString());
		//System.out.println(Conferencia2.getAcceptedArticles().toString());
		
		assertTrue(Conferencia2.getAcceptedArticles().containsAll(Aprovados2));
		assertTrue(Conferencia2.getAcceptedArticles().containsAll(AprovadosSO));
		assertFalse(Conferencia2.getAcceptedArticles().contains(database.getArticleById(6)));
		assertFalse(Conferencia2.getAcceptedArticles().containsAll(Misto));
		assertFalse(Conferencia2.getAcceptedArticles().containsAll(Rejeitados2));
		
	}
	
	@Test
	public void rejectedArticlesTests() {
		

		Conference Conferencia2 = database.getConferenceById(2);
		
		List <Article> Rejeitados2 = Arrays.asList(database.getArticleById(5),database.getArticleById(6));
		List <Article> Misto = Arrays.asList(database.getArticleById(5),database.getArticleById(4),database.getArticleById(2));
		
		//System.out.println(Conferencia2.getArticles().toString());
		//System.out.println(Conferencia2.getRejectedArticles().toString());
		
		assertTrue(Conferencia2.getRejectedArticles().containsAll(Rejeitados2));
		assertTrue(Conferencia2.getRejectedArticles().contains(database.getArticleById(5)));
		assertFalse(Conferencia2.getRejectedArticles().containsAll(Misto));
		assertFalse(Conferencia2.getRejectedArticles().contains(database.getArticleById(3)));
		
		
	}	
	
}