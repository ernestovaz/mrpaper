package mrpaper.business;

import java.util.List;

import mrpaper.business.domain.Conference;

public interface ConferenceService {

	public List<Conference> getConferences();
	public void allocateConference(String conference, int numReviewers);
}
