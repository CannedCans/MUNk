package munk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Committee implements Serializable {

    /** Delegates in the Committee */
    private HashMap<Integer, Delegate> delegates = new HashMap<Integer, Delegate>();
    
    /** User friendly name for the Committee */
    private String committeeName;
    
    /** Sessions of the Committee. */
    private ArrayList<Session> sessions = new ArrayList<Session>();
    
    /** The current Session of the Committee. */
    private Session currentSession;
    
    /** The Primary SpeakersList for the Committee */
    private SpeakersList<Delegate> primarySpeakersList = new SpeakersList<>();
    
    /** The Secondary SpeakersList for the Committee */
    private SpeakersList<Delegate> secondarySpeakersList = new SpeakersList<>();

    public Committee(String committeeName) {
    	this.committeeName = committeeName;
        currentSession = new Session(1);
        sessions.add(currentSession);
    }

    public Committee(ArrayList<Delegate> delegates, String committeeName) {
    	this(committeeName);
        for (Delegate delegate : delegates) {
        	this.addDelegate(delegate);
        }
    }

    /**
     * Add a Delegate, does not add to Roll Call information.
     * 
     * @param delegate Delegate to add
     */
    public void addDelegate(Delegate delegate) {
        while (delegates.containsKey(delegate.getDelegateID())) {
        	delegate.setDelegateID(delegate.getDelegateID() + 1);
        }
        
        delegates.put(delegate.getDelegateID(), delegate);
    }
    
    /**
     * Updates a Delegate's roll call information for the current Session.
     * 
     * @param delegate Delegate to update
     * @param rollCallState Roll Call Information for the Delegate for the current Session
     */
    public void updateRollCall(Delegate delegate, String rollCallState) {
    	currentSession.rollCall(delegate, rollCallState);
    }

    public void addResolution(ArrayList<Delegate> sponsors, ArrayList<Delegate> signatories, String title, String content) {
        Resolution resolution = new Resolution(sponsors, signatories, title, content);

        currentSession.addResolution(resolution);
    }
    
    /**
     * Starts a new Session
     * 
     */
    public void newSession() {
    	currentSession = new Session(currentSession.getSessionNumber() + 1);
    	sessions.add(currentSession);
    }
    
    public void rollCall() {
      for (Delegate delegate : delegates.values()) {
          String state = MainWindow.requestSimpleInfoPopup("Roll Call!", "Roll call info for: " + delegate.getShortRole());
          updateRollCall(delegate, state);
      }
    }
    
    /**
     * Returns all Resolutions in the Committee
     * 
     * @return ArrayList of Resolutions
     */
    public ArrayList<Resolution> getResolutions() {
    	ArrayList<Resolution> resolutions = new ArrayList<Resolution>();
    	
    	for (Session session : sessions) {
    		resolutions.addAll(session.getResolutions());
    	}
    	
    	return resolutions;
    }
    
    
    /**
     * Returns all Motions in the Committee
     * 
     * @return ArrayList of Motions
     */
    public ArrayList<Motion> getMotions() {
    	ArrayList<Motion> motions = new ArrayList<Motion>();
    	
    	for (Session session : sessions) {
    		motions.addAll(session.getMotions());
    	}
    	
    	return motions;
    }
    
    /**
     * Gets the first Delegate with the delegateID id
     * 
     * @param id
     * @return first Delegate with a matching delegateID, null otherwise
     */
    public Delegate getDelegateByID(int id) {
    	if (delegates.containsKey(id)) {
    		return delegates.get(id);
    	} else {
    		return null;
    	}
    }

	public String getCommitteeName() {
		return committeeName;
	}

	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}
    
    
}
