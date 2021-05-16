package mrpaper.business.domain;

import java.util.List;

public class Conference {
	
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
		return null;
	}
	
	public List<Article> getRejectedArticles(){
		return null;
	}
	
	public void sortReviewers(){
		
		
	}
	public List<Researcher> validReviewers(Article article){
		return null;
	}
	
	
	

}
