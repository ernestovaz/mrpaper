package mrpaper.business;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;

public interface ArticleService {
	
	void rateArticle(Article article, Researcher reviwer, Integer rating);

}
