package mrpaper.business.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public void allocateArticles(int numReviewers) {
		
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
