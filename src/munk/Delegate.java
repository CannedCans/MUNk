package munk;

import java.util.ArrayList;

public class Delegate {
	
	/** The country/character the delegate is representing/playing. */
	private String role;
	
	/** Shorter version of a name/role in case a name is difficult to type 
	 *  Defaults to the same as the full name
	 *
	 */
	private String shortRole;
	
	/** The real name of the delegate. */
	private String delegateName;
	
	/** The school that the delegate attends. */
	private String delegateSchool;
	
	/** Motions the delegate has introduced. */
	private ArrayList<Motion> motions;
	
	/** Resolutions the delegate has introduced. */
	private ArrayList<Resolution> resolutions;
	
	public Delegate() {
		motions = new ArrayList<Motion>();
		resolutions = new ArrayList<Resolution>();
	}
	
	public Delegate (String role) {
		this();
		this.role = role;
		shortRole = role;
	}

}
