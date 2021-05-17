package mrpaper.business.impl;

import java.util.Comparator;

import mrpaper.business.domain.Researcher;

public class ResearcherComparator implements Comparator<Researcher>{
	private int conferenceId;
	public ResearcherComparator(int conferenceId) {
		this.conferenceId = conferenceId;
	}
	@Override 
	public int compare(Researcher r1, Researcher r2){
		//System.out.printf("r1id:%d r1alok:%d\n",r1.getId(),r1.getAllocation(conferenceId));
		//System.out.printf("r2id:%d r2alok:%d\n",r2.getId(),r2.getAllocation(conferenceId));
		if (r1.getAllocation(conferenceId) < r2.getAllocation(conferenceId))
			return -1;
		else if(r1.getAllocation(conferenceId) > r2.getAllocation(conferenceId))
			return 1;
		else if (r1.getId() < r2.getId())
			return -1;
		else return 1;
	}
}
