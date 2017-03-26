package munk;

import java.util.ArrayList;

public class Session {

	/** Integer to store next Session number. */
	private static int sessionCount = 1;
	
	/** Session number of this Session. */
	private int sessionNumber;
	
	private ArrayList<Resolution> resolutions;
	
	private ArrayList<Motion> motions;
	
	public Session() {
		sessionNumber = sessionCount++;
		resolutions = new ArrayList<Resolution>();
		motions = new ArrayList<Motion>();
	}
	
	public void addResolution(Resolution resolution) {
		resolutions.add(resolution);
	}
}
