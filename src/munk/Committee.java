package munk;

import java.io.Serializable;
import java.util.ArrayList;

public class Committee implements Serializable {

    /** Delegates in the Committee */
    private ArrayList<Delegate> delegates;
    
    /** Sessions of the Committee. */
    private ArrayList<Session> sessions;
    
    /** The current Session of the Committee. */
    private Session currentSession;

    public Committee() {
        delegates = new ArrayList<Delegate>();
        sessions = new ArrayList<Session>();
        currentSession = new Session();
        sessions.add(currentSession);
    }

    public Committee(ArrayList<Delegate> delegates) {
        this.delegates = delegates;
    }

    /**
     * Add a Delegate, does not add to Roll Call information.
     * 
     * @param delegate Delegate to add
     */
    public void addDelegate(Delegate delegate) {
        this.delegates.add(delegate);
    }
    
    /**
     * Updates a Delegate's roll call information.
     * 
     * @param delegate Delegate to update
     * @param rollCallState Roll Call Information for the Delegate for the Session
     */
    public void updateRollCall(Delegate delegate, String rollCallState) {
    	currentSession.rollCall(delegate, rollCallState);
    }

    public void addResolution(ArrayList<Delegate> sponsors, ArrayList<Delegate> signatories, String title, String content) {
        Resolution resolution = new Resolution(sponsors, signatories, title, content);

        currentSession.addResolution(resolution);
    }
    
    public void newSession() {
    	currentSession = new Session();
    	sessions.add(currentSession);
    }
    
    public void rollCall() {
      for (Delegate delegate : delegates) {
          String state = MainWindow.requestInfoPopup("Roll Call!", "Roll call info for: " + delegate.getShortRole());
          updateRollCall(delegate, state);
      }
    }
    
}
