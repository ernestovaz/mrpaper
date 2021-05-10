package mrpaper.business;

import java.util.List;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Conference;
import mrpaper.business.domain.Researcher;

public interface ConferenceService {

	void allocateArticleToResearcher(Article article, Researcher researcher);
	List<Article> selectedArticles(Conference conference);
	List<Researcher> sortReviwers(List<Researcher> reviewers);
}
