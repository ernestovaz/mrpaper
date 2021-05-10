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
			save(t1);
			
			Topic t2 = new Topic(2, "Software Reuse");
			save(t2);
			
			Topic t3 = new Topic(3, "Modularity");
			save(t3);
			
			Topic t4 = new Topic(4, "Software Architecture");
			save(t4);
			
			Topic t5 = new Topic(5, "Software Testing");
			save(t5);
			
			Topic t6 = new Topic(6, "Aspect-oriented Programming");
			save(t6);
			
			University u1 = new University(1, "UFRGS");
			save(u1);
			
			University u2 = new University(2, "USP");
			save(u2);
			
			University u3 = new University(3, "UFRJ");
			save(u3);
			
			Researcher r1 = new Researcher(1, "João", u1);
			save(r1);
			
			Researcher r2 = new Researcher(2, "Ana", u2);
			save(r2);
			
			Researcher r3 = new Researcher(3, "Manoel", u1);
			save(r3);
			
			Researcher r4 = new Researcher(4, "Joana", u3);
			save(r4);
			
			Researcher r5 = new Researcher(5, "Miguel", u1);
			save(r5);
			
			Researcher r6 = new Researcher(6, "Beatriz", u3);
			save(r6);
			
			Researcher r7 = new Researcher(7, "Suzana", u1);
			save(r7);
			
			Researcher r8 = new Researcher(8, "Natasha", u3);
			save(r8);
			
			Researcher r9 = new Researcher(9, "Pedro", u2);
			save(r9);
			
			Researcher r10 = new Researcher(10, "Carlos", u2);
			save(r10);
			
			Conference c1 = new Conference(1, "ICSE", new ArrayList<>(), Arrays.asList(r1,r2,r3,r4,r5,r6));
			save(c1);
			
			Conference c2 = new Conference(2, "FSE", new ArrayList<>(), Arrays.asList(r1,r2,r3,r4,r5,r6));
			save(c2);
			
			Conference c3 = new Conference(3, "SBES", new ArrayList<>(), Arrays.asList(r4,r5,r6,r7,r8,r9,r10));
			save(c3);
			
			
			Article a1 = new Article(1, "Coupling and Cohesion", r1, c3, t3);
			save(a1);
			
			Article a2 = new Article(2, "Design Patterns", r6, c2, t2);
			save(a2);
			
			Article a3 = new Article(3, "AspectJ", r7, c2, t6);
			save(a3);
			
			Article a4 = new Article(4, "Feature Model", r8, c2, t1);
			save(a4);
			
			Article a5 = new Article(5, "Architecture Recovery", r9, c2, t4);
			save(a5);
			
			Article a6 = new Article(6, "Functional Testing", r10, c2, t5);
			save(a6);
			
			Article a7 = new Article(7, "COTs", r6, c1, t2);
			save(a7);
			
			Article a8 = new Article(8, "Pointcut", r7, c1, t6);
			save(a8);
			
			Article a9 = new Article(9, "Product Derivation", r8, c1, t1);
			save(a9);
			
			Article a10 = new Article(10, "Architecture Comformance", r9, c1, t4);
			save(a10);
			
			Article a11 = new Article(11, "Structural Testing", r10, c1, t5);
			save(a11);
			
			
			Review review1 = new Review(1, a1, r8, 2);
			save(review1);

			Review review2 = new Review(2, a1, r10, null);
			save(review2);
			
			Review review3 = new Review(3, a2, r7, 2);
			save(review3);
			
			Review review4 = new Review(4, a2, r2, 3);
			save(review4);
			
			Review review5 = new Review(5, a3, r4, -1);
			save(review5);
			
			Review review6 = new Review(6, a3, r6, 1);
			save(review6);
			
			Review review7 = new Review(7, a4, r1, 1);
			save(review7);
			
			Review review8 = new Review(8, a4, r3, 0);
			save(review8);
			
			Review review9 = new Review(9, a5, r4, -3);
			save(review9);
			
			Review review10 = new Review(10, a5, r5, -3);
			save(review10);
			
			Review review11 = new Review(11, a6, r3, -1);
			save(review11);
			
			Review review12 = new Review(12, a6, r6, 0);
			save(review12);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Collection<Researcher> getAllResearchers() {
		return this.researchers.values();
	}
	
	public Collection<Conference> getAllConferences() {
		return this.conferences.values();
	}
	
	public Collection<Article> getAllArticles() {
		return this.articles.values();
	}
	
	public Collection<Review> getAllReviews() {
		return this.reviews.values();
	}
	
	public Collection<University> getAllUniversities() {
		return this.universities.values();
	}
	
	public Collection<Topic> getAllTopics() {
		return this.topics.values();
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
		this.reviews.put(reviews.getId(), reviews);
	}
	
	public void save(Researcher researcher) {
		this.researchers.put(researcher.getId(), researcher);
	}

}
