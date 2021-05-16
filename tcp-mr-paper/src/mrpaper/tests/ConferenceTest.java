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
		Conferencia2.sortReviewers(Conferencia2.getCommitte());
		
	}
	
	@Test
	public void selectedArticlesTests() {
		
		
		
	}
	
	@Test
	public void rejectedArticlesTests() {
		
		
		
	}	

}