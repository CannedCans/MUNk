package munk;

public class Motion {
	
	/** The Delegate that introduced the Motion. */
	private Delegate author;
	
	/** The type of Motion. */
	private String type;
	
	/** The time the Motion was introduced. */
	private String time;
	
	/** The total duration of the Motion (if applicable). */
	private String duration;
	
	/** The speaking time of the Motion (if applicable). */
	private String speakingTime;
	
	/** Whether or not the Motion passed. */
	private boolean passed;
}
