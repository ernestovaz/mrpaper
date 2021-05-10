package mrpaper.business.impl;

import java.util.List;

import mrpaper.business.ConferenceService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Conference;
import mrpaper.business.domain.Researcher;
import mrpaper.data.Database;

public class ConferenceServiceImpl implements ConferenceService {
	
	private final Database database;
	
	public ConferenceServiceImpl(Database database){
		this.database = database;
	}

	@Override
	public void allocateArticleToResearcher(Article article, Researcher researcher) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> selectedArticles(Conference conference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Researcher> sortReviwers(List<Researcher> reviewers) {
		// TODO Auto-generated method stub
		return null;
	}

}
