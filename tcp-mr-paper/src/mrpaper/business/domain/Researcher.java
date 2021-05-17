package mrpaper.business.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Researcher{
	
	private int id;
	private String name;
	private List<Topic> interests;
	private University affiliation;
	private List<Review> reviews;
	private HashMap<Integer,Integer> allocations;

	public Researcher(int id, String name, University affiliation, List<Topic> interests) {
		this.id = id;
		this.name = name;
		this.affiliation = affiliation;
		this.reviews = new ArrayList<>();
		this.interests = interests;
		this.allocations = new HashMap<Integer,Integer>();
	}
	public Researcher(int id, String name, University affiliation,Topic[] interests) {
		this(id,name,affiliation,Arrays.asList(interests));
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

	public List<Topic> getInterests() {
		return interests;
	}

	public void setInterests(List<Topic> interests) {
		this.interests = interests;
	}

	public University getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(University affiliation) {
		this.affiliation = affiliation;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void includeReview(Review review) {
		this.reviews.add(review);
	}
	
	public void addAllocation(int conferenceId) {
		this.allocations.merge(conferenceId, 1, Integer::sum);
	}
	
	public int getAllocation(int conferenceId) {
		Integer query = this.allocations.get(conferenceId);
		int allocations;
		if (query == null)
			allocations = 0;
		else
			allocations = query.intValue();
		return allocations;
	}

	@Override 
	public String toString() {
		return String.format("[ID: %s, NAME: %s, AFFILIATION: %s]",
				this.id, this.name, this.affiliation.toString());
	}
}
