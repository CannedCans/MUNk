package munk;

import java.util.ArrayList;

public class Committee {

    /** Delegates in the Committee */
    private ArrayList<Delegate> delegates;

    private ArrayList<Resolution> resolutions;

    private ArrayList<Motion> motions;

    public Committee() {
        if (delegates == null) {
            delegates = new ArrayList<Delegate>();
        }
        resolutions = new ArrayList<Resolution>();
        motions = new ArrayList<Motion>();
    }

    public Committee(ArrayList<Delegate> delegates) {
        this.delegates = delegates;
        this();
    }

    public void addDelegate(Delegate delegate) {
        this.delegates.add(delegate);
    }

}
