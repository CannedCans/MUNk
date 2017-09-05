package munk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Session implements Serializable {
	
	/** Session number of this Session, unique within the Committee */
	private int sessionNumber;
	
	private ArrayList<Resolution> resolutions;
	
	private ArrayList<Motion> motions;
	
	private HashMap<Delegate, String> rollCallInfo;
	
	public Session(int sessionNumber) {
		this.sessionNumber = sessionNumber;
		resolutions = new ArrayList<Resolution>();
		motions = new ArrayList<Motion>();
		rollCallInfo = new HashMap<Delegate, String>();
	}
	
	/**
	 * Adds a Resolution to the Session's list of Resolutions
	 * 
	 * @param resolution
	 */
	public void addResolution(Resolution resolution) {
		resolutions.add(resolution);
	}
	
	/**
	 * Sets the roll call state of a Delegate to state
	 * 
	 * @param delegate
	 * @param state
	 */
	public void rollCall(Delegate delegate, String state) {
		rollCallInfo.put(delegate, state);
	}

	public ArrayList<Resolution> getResolutions() {
		return resolutions;
	}

	public ArrayList<Motion> getMotions() {
		return motions;
	}
	
	/**
	 * Returns the Delegate's roll call status for the Session
	 * @param delegate the Delegate to get the status for
	 * @return Roll Call Status for the Delegate
	 */
	public String getDelegateAttendance(Delegate delegate) {
		if (rollCallInfo.containsKey(delegate)) {
			return rollCallInfo.get(delegate);
		} else {
			return "Delegate did not exist at time of session";
		}
	}
	
	public int getSessionNumber() {
		return sessionNumber;
	}
	
	
}
