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
		
		
		Conference Conferencia2 = database.getConferenceById(2);
		//Conferencia2.sortReviewers(Conferencia2.getCommitte());
		
	}
	
	@Test
	public void selectedArticlesTests() {
	
		Conference Conferencia2 = database.getConferenceById(2);
		
		List <Article> Aprovados2 = Arrays.asList(database.getArticleById(2));
		Aprovados2.add(database.getArticleById(3));
		Aprovados2.add(database.getArticleById(4));
		
		List <Article> Rejeitados2 = Arrays.asList(database.getArticleById(5));
		Rejeitados2.add(database.getArticleById(6));
		
		List <Article> AprovadosSO = Arrays.asList(database.getArticleById(2));
		Aprovados2.add(database.getArticleById(4));
		Aprovados2.add(database.getArticleById(3));
		
		List <Article> Misto = Arrays.asList(database.getArticleById(5));
		Misto.add(database.getArticleById(4));
		Misto.add(database.getArticleById(2));
		
		assertTrue(Conferencia2.getAcceptedArticles() == Aprovados2);
		assertFalse(Conferencia2.getAcceptedArticles() == AprovadosSO);
		assertFalse(Conferencia2.getAcceptedArticles() == Rejeitados2);
		assertFalse(Conferencia2.getAcceptedArticles() == Misto);
		
	}
	
	@Test
	public void rejectedArticlesTests() {
		
		Conference Conferencia2 = database.getConferenceById(2);
		
		List <Article> Aprovados2 = Arrays.asList(database.getArticleById(2));
		Aprovados2.add(database.getArticleById(3));
		Aprovados2.add(database.getArticleById(4));
		
		List <Article> Rejeitados2 = Arrays.asList(database.getArticleById(5));
		Rejeitados2.add(database.getArticleById(6));
		
		List <Article> AprovadosSO = Arrays.asList(database.getArticleById(2));
		Aprovados2.add(database.getArticleById(4));
		Aprovados2.add(database.getArticleById(3));
		
		List <Article> Misto = Arrays.asList(database.getArticleById(5));
		Misto.add(database.getArticleById(4));
		Misto.add(database.getArticleById(2));
		
		assertFalse(Conferencia2.getAcceptedArticles() == Aprovados2);
		assertFalse(Conferencia2.getAcceptedArticles() == AprovadosSO);
		assertTrue(Conferencia2.getAcceptedArticles() == Rejeitados2);
		assertFalse(Conferencia2.getAcceptedArticles() == Misto);
		
		
		
	}	

}