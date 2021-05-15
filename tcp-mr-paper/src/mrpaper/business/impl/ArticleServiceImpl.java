package mrpaper.business.impl;

import java.util.List;
import java.util.ArrayList;

import mrpaper.business.ArticleService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Review;
import mrpaper.data.Database;


public class ArticleServiceImpl implements ArticleService {
	
	private final Database database;
	
	public ArticleServiceImpl(Database database) {
		this.database = database;
	}
	
	public List<Article> getArticles(){
		List<Article> articles = new ArrayList<Article>();
		articles.addAll(database.getAllArticles());
		return articles;
	}
	
	public void setRating(Review review, int rating){
		review.setRating(rating);		
	}
}
