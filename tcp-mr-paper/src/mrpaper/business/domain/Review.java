package mrpaper.business.domain;

public class Review {
	
	private int id;
	private Researcher reviewer;
	private Article article;
	private Integer rating;
	
	public Review(int id, Article article, Researcher reviewer, Integer rating) {
		this.id = id;
		this.reviewer = reviewer;
		this.article = article;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
