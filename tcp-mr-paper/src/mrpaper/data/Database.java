package mrpaper.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mrpaper.business.domain.Article;
import mrpaper.business.domain.Conference;
import mrpaper.business.domain.Researcher;
import mrpaper.business.domain.Review;
import mrpaper.business.domain.Topic;
import mrpaper.business.domain.University;

public class Database {

	private final Map<Integer, Researcher> researchers;
	private final Map<Integer, Conference> conferences;
	private final Map<Integer, Article> articles;
	private final Map<Integer, Review> reviews;
	private final Map<Integer, University> universities;
	private final Map<Integer, Topic> topics;
	
	public Database() {
		this(true);
	}

	public Database(boolean initData) {
		this.researchers = new HashMap<>();
		this.conferences = new HashMap<>();
		this.articles = new HashMap<>();
		this.reviews = new HashMap<>();
		this.universities = new HashMap<>();
		this.topics = new HashMap<>();
		
		if (initData) {
			initData();
		}
	}
	
	private void initData() {
		try {
			Topic t1 = new Topic(1, "Software Product Lines");
			Topic t2 = new Topic(2, "Software Reuse");
			Topic t3 = new Topic(3, "Modularity");
			Topic t4 = new Topic(4, "Software Architecture");
			Topic t5 = new Topic(5, "Software Testing");
			Topic t6 = new Topic(6, "Aspect-oriented Programming");
			Topic t7 = new Topic(7, "Software Quality");
			
			University u1 = new University(1, "UFRGS");
			University u2 = new University(2, "USP");
			University u3 = new University(3, "UFRJ");
		
			Researcher r1 = new Researcher(1, "Joao", u1,new Topic[]{t1,t2,t3});
			Researcher r2 = new Researcher(2, "Ana", u2,new Topic[]{t4,t3,t2});
			Researcher r3 = new Researcher(3, "Manoel", u1,new Topic[]{t1,t5});
			Researcher r4 = new Researcher(4, "Joana", u3,new Topic[]{t1,t2,t4,t6});
			Researcher r5 = new Researcher(5, "Miguel", u1,new Topic[]{t4,t3,t5});
			Researcher r6 = new Researcher(6, "Beatriz", u3,new Topic[]{t2,t5,t6});
			Researcher r7 = new Researcher(7, "Suzana", u1,new Topic[]{t6,t3,t2});
			Researcher r8 = new Researcher(8, "Natasha", u3,new Topic[]{t3,t2,t7,t1});
			Researcher r9 = new Researcher(9, "Pedro", u2,new Topic[]{t6,t4});
			Researcher r10 = new Researcher(10, "Carlos", u2,new Topic[]{t2,t3});

			Conference c1 = new Conference(1, "ICSE", new ArrayList<>(), Arrays.asList(r1,r2,r3,r4,r5,r6));
			Conference c2 = new Conference(2, "FSE", new ArrayList<>(), Arrays.asList(r1,r2,r3,r4,r5,r6));
			Conference c3 = new Conference(3, "SBES", new ArrayList<>(), Arrays.asList(r4,r5,r6,r7,r8,r9,r10));

			Article a1 = new Article(1, "Coupling and Cohesion", r1, c3, t3);
			Article a2 = new Article(2, "Design Patterns", r6, c2, t2);
			Article a3 = new Article(3, "AspectJ", r7, c2, t6);
			Article a4 = new Article(4, "Feature Model", r8, c2, t1);
			Article a5 = new Article(5, "Architecture Recovery", r9, c2, t4);
			Article a6 = new Article(6, "Functional Testing", r10, c2, t5);
			Article a7 = new Article(7, "COTs", r6, c1, t2);
			Article a8 = new Article(8, "Pointcut", r7, c1, t6);
			Article a9 = new Article(9, "Product Derivation", r8, c1, t1);
			Article a10 = new Article(10, "Architecture Comformance", r9, c1, t4);
			Article a11 = new Article(11, "Structural Testing", r10, c1, t5);
			
			c3.setArticles(Arrays.asList(a1));
			c2.setArticles(Arrays.asList(a2,a3,a4,a5,a6));
			c1.setArticles(Arrays.asList(a7,a8,a9,a10,a11));
			
			Review review1 = new Review(1,a1, r8, 2);
	
			Review review2 = new Review(2,a1, r10, null);
			
			Review review3 = new Review(3,a2, r7, 2);
			
			Review review4 = new Review(4,a2, r2, 3);
			
			Review review5 = new Review(5,a3, r4, -1);

			Review review6 = new Review(6,a3, r6, 1);
			
			Review review7 = new Review(7,a4, r1, 1);

			Review review8 = new Review(8,a4, r3, 0);
			
			Review review9 = new Review(9,a5, r4, -3);
			
			Review review10 = new Review(10,a5, r5, -3);
			
			Review review11 = new Review(11,a6, r3, -1);
			
			Review review12 = new Review(12,a6, r6, 0);
			
			save(t1);
			save(t2);
			save(t3);
			save(t4);
			save(t5);
			save(t6);
			save(t7);

			save(u1);
			save(u2);
			save(u3);

			save(r1);
			save(r2);
			save(r3);
			save(r4);
			save(r5);
			save(r6);
			save(r7);
			save(r8);
			save(r9);
			save(r10);
			
			save(c1);
			save(c2);
			save(c3);
			
			save(a1);
			save(a2);
			save(a3);
			save(a4);
			save(a5);
			save(a6);
			save(a7);
			save(a8);
			save(a9);
			save(a10);
			save(a11);
			
			save(review1);
			save(review2);
			save(review3);
			save(review4);
			save(review5);
			save(review6);
			save(review7);
			save(review8);
			save(review9);
			save(review10);
			save(review11);
			save(review12);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Collection<Researcher> getAllResearchers() {
		return this.researchers.values();
	}
	
	public Researcher getResearcherById(int id) {
		return this.researchers.get(id);
	}
	
	public Collection<Conference> getAllConferences() {
		return this.conferences.values();
	}
	
	public Conference getConferenceById(int id) {
		return this.conferences.get(id);
	}
	
	public Conference getConferenceByInitials(String initials) {
		for (int id : conferences.keySet()) {
			if(conferences.get(id).getInitials().equals(initials))
				return conferences.get(id);
		}
		return null;
	}
	
	public Collection<Article> getAllArticles() {
		return this.articles.values();
	}
	
	public Article getArticleById(int id) {
		return this.articles.get(id);
	}
	
	public Collection<Review> getAllReviews() {
		return this.reviews.values();
	}
	
	public Review getReviewById(int id) {
		return this.reviews.get(id);
	}
	
	public Collection<University> getAllUniversities() {
		return this.universities.values();
	}
	
	public University getUniversityById(int id) {
		return this.universities.get(id);
	}
	
	public Collection<Topic> getAllTopics() {
		return this.topics.values();
	}
	
	public Topic getTopicById(int id) {
		return this.topics.get(id);
	}
	
	public void save(Article article) {
		this.articles.put(article.getId(), article);
	}
	
	public void save(Conference conference) {
		this.conferences.put(conference.getId(), conference);
	}
	
	public void save(University university) {
		this.universities.put(university.getId(), university);
	}
	
	public void save(Topic topic) {
		this.topics.put(topic.getId(), topic);
	}
	
	public void save(Review reviews) {
		this.reviews.put(reviews.getId(),reviews);
		reviews.getReviewer().addAllocation(reviews.getArticle().getConference().getId());
		reviews.getReviewer().includeReview(reviews);
		reviews.getArticle().includeReview(reviews);
	}
	
	public void includeReview(Review reviews) {
		this.reviews.put(reviews.getId(),reviews);
	}
	
	public void save(Researcher researcher) {
		this.researchers.put(researcher.getId(), researcher);
	}

}
