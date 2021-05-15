package mrpaper.business.impl;

import java.util.ArrayList;
import java.util.List;

import mrpaper.business.ConferenceService;
import mrpaper.business.domain.Conference;
import mrpaper.data.Database;

public class ConferenceServiceImpl implements ConferenceService {
	
	private final Database database;
	
	public ConferenceServiceImpl(Database database){
		this.database = database;
	}
	public List<Conference> getConferences(){
		List<Conference> conferences = new ArrayList<Conference>();
		conferences.addAll(database.getAllConferences());
		return conferences;
	}
	public void allocateConference(String conference, int numReviewers) {

	}
	
}
