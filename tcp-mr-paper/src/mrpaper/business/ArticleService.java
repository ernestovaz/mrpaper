package mrpaper.business;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;
import mrpaper.business.domain.Review;

import java.util.List;

public interface ArticleService {
	public List<Article> getArticles();
	public void setRating(Review review, int rating);
}
