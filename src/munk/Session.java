package munk;

import java.util.ArrayList;
import java.util.HashMap;

public class Session {

	/** Integer to store next Session number. */
	private static int sessionCount = 1;
	
	/** Session number of this Session. */
	private int sessionNumber;
	
	private ArrayList<Resolution> resolutions;
	
	private ArrayList<Motion> motions;
	
	private HashMap<Delegate, String> rollCallInfo;
	
	public Session() {
		sessionNumber = sessionCount++;
		resolutions = new ArrayList<Resolution>();
		motions = new ArrayList<Motion>();
		rollCallInfo = new HashMap<Delegate, String>();
	}
	
	public void addResolution(Resolution resolution) {
		resolutions.add(resolution);
	}
	
	public void rollCall(Delegate delegate, String state) {
		rollCallInfo.put(delegate, state);
	}
}
