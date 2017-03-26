package munk;

import java.util.ArrayList;

public class Committee {

    /** Delegates in the Committee */
    private ArrayList<Delegate> delegates;

    /** Resolutions introduced into the Committee. */
    private ArrayList<Resolution> resolutions;

    /** Motions introduced into the Committee. */
    private ArrayList<Motion> motions;
    
    /** Sessions of the Committee. */
    private ArrayList<Session> sessions;
    
    /** The current Session of the Committee. */
    private Session currentSession;

    public Committee() {
        delegates = new ArrayList<Delegate>();
        resolutions = new ArrayList<Resolution>(); //Duplicated code, might be fixable later.
        motions = new ArrayList<Motion>();
        sessions = new ArrayList<Session>();
        currentSession = new Session();
        sessions.add(currentSession);
    }

    public Committee(ArrayList<Delegate> delegates) {
        this.delegates = delegates;
        resolutions = new ArrayList<Resolution>();
        motions = new ArrayList<Motion>();
    }

    public void addDelegate(Delegate delegate) {
        this.delegates.add(delegate);
    }

    public void addResolution(ArrayList<Delegate> sponsors, ArrayList<Delegate> signatories, String title, String content) {
        Resolution resolution = new Resolution(sponsors, signatories, title, content);

        for (Delegate delegate : sponsors) { //Also duplicated code, might be fixable
            delegate.addResolution(resolution);
        }

        for (Delegate delegate : signatories) {
            delegate.addResolution(resolution);
        }
        currentSession.addResolution(resolution);
    }

}
