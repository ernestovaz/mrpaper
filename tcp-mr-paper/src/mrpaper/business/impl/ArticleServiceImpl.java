package mrpaper.business.impl;

import mrpaper.business.ArticleService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;
import mrpaper.data.Database;

public class ArticleServiceImpl implements ArticleService {
	
	private final Database database;
	
	public ArticleServiceImpl(Database database) {
		this.database = database;
	}

	@Override
	public void rateArticle(Article article, Researcher reviwer, Integer rating) {
		// TODO Auto-generated method stub
	}

}
