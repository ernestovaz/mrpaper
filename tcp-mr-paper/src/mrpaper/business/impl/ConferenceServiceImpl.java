package mrpaper.business.impl;

import java.util.ArrayList;
import java.util.List;

import mrpaper.business.ConferenceService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Conference;
import mrpaper.business.domain.Review;
import mrpaper.data.Database;
import mrpaper.exceptions.NotAConvention;
import mrpaper.exceptions.NotAConventionException;

public class ConferenceServiceImpl implements ConferenceService {
	
	private final Database database;
	
	public ConferenceServiceImpl(Database database){
		this.database = database;
	}
	public List<Conference> getConferences(){
		List<Conference> conferences = new ArrayList<Conference>();
		conferences.addAll(database.getAllConferences());
		return conferences;
	}
	public List<Review> allocateConference(String initials, int numReviewers) {
		Conference conference = database.getConferenceByInitials(initials);
		if (conference == null) 
		{
			throw new NotAConventionException("Informe uma convencao valida");	
		}
		List<Review> newReviews = conference.allocateArticles(numReviewers);
		int numReviews = database.getAllReviews().size();
		int count = 1;
		for (Review review : newReviews) {
			review.setId(numReviews+count);
			database.includeReview(review);
			count += 1;
		}
		return newReviews;
	}

	public List<Article> articleAcceptedReport(String initials) {
		Conference conference = database.getConferenceByInitials(initials);
		if (conference == null) 
		{
			throw new NotAConventionException("Informe uma convencao valida");	
		}
		if(conference.isFullyAllocated())
			return conference.getAcceptedArticles();
		else return null;
	}

	
	public List<Article> articleRejectedReport(String initials) {
		Conference conference = database.getConferenceByInitials(initials);
		if(conference.isFullyAllocated())
			return conference.getRejectedArticles();
		else return null;
	}
	
	
	
}
