package mrpaper.domain;

public class Review {
	
	private int id;
	private Researcher researcher;
	private Article article;
	private Integer rating;
	
	public Review(int id, Researcher reseacher, Article article) {
		this.id = id;
		this.researcher = reseacher;
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
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
