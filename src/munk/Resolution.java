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

	public boolean isSponsor(Delegate delegate) {
		return sponsors.contains(delegate);
	}

}
