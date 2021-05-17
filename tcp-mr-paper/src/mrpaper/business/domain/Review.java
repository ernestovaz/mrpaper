package mrpaper.business.domain;

public class Review {
	
	private Researcher reviewer;
	private Article article;
	private Integer rating;
	
	public Review(Article article, Researcher reviewer, Integer rating) {
		this.reviewer = reviewer;
		this.article = article;
		this.rating = rating;
	}


	public Researcher getReviewer() {
		return reviewer;
	}

	public void setReviewer(Researcher researcher) {
		this.reviewer = researcher;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
