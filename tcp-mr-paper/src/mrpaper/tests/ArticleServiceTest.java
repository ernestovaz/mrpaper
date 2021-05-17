package mrpaper.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mrpaper.business.ArticleService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;
import mrpaper.business.domain.Review;
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
		ArticleServiceImpl aaa = new ArticleServiceImpl(database);
		int originalSize = a1.getReviews().size();
		int reviewedbyr1 = r1.getReviews().size();
		
		Review re1 = new Review(a1,r1,null);
		r1.includeReview(re1);
		a1.includeReview(re1);
		aaa.setRating(re1, 0);	
	
		assertEquals(a1.getReviews().size(), originalSize + 1);
		assertEquals(r1.getReviews().size(), reviewedbyr1 + 1);
		assertEquals(re1.getReviewer(),r1);
		assertEquals(re1.getArticle(),a1);
	}
}

