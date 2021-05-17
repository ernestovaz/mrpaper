package mrpaper.business.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		return descSortArticle(AcceptedArticles);
	}
	
	public List<Article> getRejectedArticles(){
		int i;
		List<Article> RejectedArticles = new ArrayList<Article>();
		
		for (i = 0; i < getArticles().size(); i++) {
			if(getArticles().get(i).AverageGrade() < 0) {
				RejectedArticles.add(getArticles().get(i));
		}}	
		return ascSortArticle(RejectedArticles);
	}
	
	
    public List<Article> descSortArticle(List<Article> articles){
    	Collections.sort(articles, new Comparator<Article>(){
        public int compare(Article a1, Article a2) {
            if (a1.AverageGrade() > a2.AverageGrade())
                return -1;
            else return 1;
        }
    });
    return articles;
}

    public List<Article> ascSortArticle(List<Article> articles){
    	Collections.sort(articles, new Comparator<Article>(){
        public int compare(Article a1, Article a2) {
            if (a1.AverageGrade() < a2.AverageGrade())
                return -1;
            else return 1;
        }
    });
    return articles;
}
	
	public boolean isFullyAllocated() {
		List<Review> articleReviews;
		if(articles.isEmpty())
			return false;
		for(Article article : articles) {		
			articleReviews = article.getReviews();
			if(articleReviews.isEmpty()) 
				return false;
			for(Review review : articleReviews) 
				if(review.getRating()==null)
					return false;
		}
		return true;
	}
	
		
	public List<Researcher> sortReviewers(List<Researcher> reviewers){
		Collections.sort(reviewers,new ResearcherComparator(this.id));
		return reviewers;
	}
	
	public List<Researcher> validReviewers(Article article){
		return null;
	}
}
