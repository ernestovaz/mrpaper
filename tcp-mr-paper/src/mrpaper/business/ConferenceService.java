package mrpaper.business;

import java.util.List;

import mrpaper.business.domain.Conference;
import mrpaper.business.domain.Review;

public interface ConferenceService {

	public List<Conference> getConferences();
	public List<Review> allocateConference(String conference, int numReviewers);
}
