package munk;

import java.util.ArrayList;

public class Resolution {

	/** The Delegates that sponsored the Resolution. */
	private ArrayList<Delegate> sponsors;

	/** The Delegates that were signatories to the Resolution. */
	private ArrayList<Delegate> signatories;

	/** The time the Resolution was introduced. */
	private String timeIntroduced;

	/** The content of the Resolution. */
	private String content;

	/** Whether or not the Resolution passed. */
	private boolean passed;
	
	/** The title of the Resolution. */
	private String title;

	public Resolution(ArrayList<Delegate> sponsors, ArrayList<Delegate> signatories, String title, String content) {
		this.sponsors = sponsors;
		this.signatories = signatories;
		this.title = title;
		this.content = content;
	}

    /**
     * Returns if a Delegate object is a sponsor of the Resolution
     * 
     * @param delegate the Delegate object being checked
     * @return true if the Delegate is a sponsor, false otherwise
     */
	public boolean isSponsor(Delegate delegate) {
		return sponsors.contains(delegate);
	}

    /**
     * Adds a Delegate to the sponsors list for the Resolution
     *
     * @param delegate the Delegate to add to the sponsors list
     *
     */
    public void addSponsor(Delegate delegate) {
	    sponsors.add(delegate);
	    
	    //TODO: Update roll calls that have passed when the delegate was created with Absent
    }

    /**
     * Adds a Delegate to the signatories list for the Resolution
     * 
     * @param delegate the Delegate to add to the signatories list
     */
    public void addSignatory(Delegate delegate) {
	    signatories.add(delegate);
    }

}
