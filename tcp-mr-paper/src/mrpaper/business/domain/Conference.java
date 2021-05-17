package mrpaper.business.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import mrpaper.business.ConferenceService;
import mrpaper.business.impl.ResearcherComparator;

public class Conference{
	private int id;
	private String initials;
	private List<Article> articles;
	private List<Researcher> committe;
	
	public Conference(int id, String initials, List<Article> articles, List<Researcher> committe) {
		this.id = id;
		this.initials = initials;
		this.articles = articles;
		this.committe = committe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Researcher> getCommitte() {
		return committe;
	}

	public void setCommitte(List<Researcher> committe) {
		this.committe = committe;
	}
	
	public List<Review> allocateArticles(int numReviewers) {
		List<Researcher> reviewers;
		List<Review> reviews = new ArrayList<>();
		Review currentReview;

		for(int i = 0; i < numReviewers; i++) {
			List<Article> articleList = new ArrayList<Article>(articles);
			do {
				Collections.sort(articleList);
				Article article = articleList.get(0);
				reviewers = article.validReviewers(committe);
				if(!reviewers.isEmpty()) {
					reviewers = sortReviewers(reviewers);
					currentReview = new Review(0,article,reviewers.get(0),null);
					Researcher assignedReviewer = reviewers.get(0);
					reviewers.get(0).addAllocation(this.id);
					reviewers.set(0,assignedReviewer);
					reviews.add(currentReview);
					assignedReviewer.includeReview(currentReview);
					article.includeReview(currentReview);
					articleList.remove(0);
				}
			}while(!articleList.isEmpty() && !reviewers.isEmpty());
		}
		
		return reviews;
	}
	
	public List<Article> getAcceptedArticles(){
		int i;
		List<Article> AcceptedArticles = new ArrayList<Article>();
		for (i = 0; i < getArticles().size(); i++) {
			if(getArticles().get(i).AverageGrade() >= 0) {
				AcceptedArticles.add(getArticles().get(i));
		}}
		return AcceptedArticles;
	}
	
	public List<Article> getRejectedArticles(){
		int i;
		List<Article> RejectedArticles = new ArrayList<Article>();
		
		for (i = 0; i < getArticles().size(); i++) {
			if(getArticles().get(i).AverageGrade() < 0) {
				RejectedArticles.add(getArticles().get(i));
		}}	
		return RejectedArticles;
	}
	
		
	public List<Researcher> sortReviewers(List<Researcher> reviewers){
		Collections.sort(reviewers,new ResearcherComparator(this.id));
		return reviewers;
	}
	
	public List<Researcher> validReviewers(Article article){
		return null;
	}
}
