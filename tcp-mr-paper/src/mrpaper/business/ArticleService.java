package mrpaper.business;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Researcher;
import java.util.List;

public interface ArticleService {
	public List<Article> getArticles();
}
