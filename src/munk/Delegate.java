package munk;

import java.util.ArrayList;

public class Delegate {

	/** The country/character the delegate is representing/playing. */
	private String role;

	/**
	 * Shorter version of a name/role in case a name is difficult to type
	 * Defaults to the same as the full name
	 *
	 */
	private String shortRole;

	/** The real name of the Delegate. */
	private String delegateName;

	/** The school that the Delegate attends. */
	private String delegateSchool;

	/** Motions the Delegate has introduced. */
	private ArrayList<Motion> motions;

	/** Resolutions the Delegate has sponsored. */
	private ArrayList<Resolution> resolutions;

	private ArrayList<Resolution> signatoryResolutions;

	public Delegate() {
		motions = new ArrayList<Motion>();
		resolutions = new ArrayList<Resolution>();
		signatoryResolutions = new ArrayList<Resolution>();
	}

	public Delegate(String role) {
		this();
		this.role = role;
		shortRole = role;
	}

	public void addResolution(Resolution resolution) {
		if (resolution.isSponsor(this)) {
			this.resolutions.add(resolution);
		} else {
			this.signatoryResolutions.add(resolution);
		}
	}

  public String getShortRole() {
    return shortRole;
  }

}
