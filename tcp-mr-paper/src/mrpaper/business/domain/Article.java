package mrpaper.business.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Article {
	
	private int id;
	private String name;
	private Researcher author;
	private Conference conference;
	private Topic topic;
	private List<Review> reviews;
	
	public Article(int id, String name, Researcher author, Conference conference, Topic topic) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.conference = conference;
		this.topic = topic;
		this.reviews = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Researcher getAuthor() {
		return author;
	}

	public void setAuthor(Researcher author) {
		this.author = author;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	@Override
	public String toString() {
		return String.format("[ID: %s, NAME: %s, AUTHOR: %s, TOPIC: %s, CONFERENCE: %s, REVIEWS: %s]",
				this.id, this.name, this.author.getName(), this.topic.toString(), this.conference.toString(), 
				this.reviews.stream().map(Review::toString).collect(Collectors.joining()));
	}

}
