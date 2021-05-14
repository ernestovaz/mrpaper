package mrpaper.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mrpaper.business.ArticleService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;
import mrpaper.business.impl.ArticleServiceImpl;
import mrpaper.data.Database;

public class ArticleServiceTest {
	
	ArticleService articleService;
	Database database;

	@Before
	public void setUp() throws Exception {
		database = new Database(true);
		articleService = new ArticleServiceImpl(database);
	}

	@Test
	public void test() {
		Article a1 = database.getArticleById(1);
		Researcher r1 = database.getResearcherById(1);
		int originalSize = a1.getReviews().size();
		articleService.rateArticle(a1, r1, 3);
		
		assertEquals(a1.getReviews().size(), originalSize + 1);
		assertEquals(r1.getReviews().size(), originalSize + 1);
	}
}

