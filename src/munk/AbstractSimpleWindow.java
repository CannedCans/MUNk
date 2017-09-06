package munk;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * An Abstract window with a JFrame and title
 * 
 * @author CannedCans
 *
 */
public abstract class AbstractSimpleWindow {
	
	/** JFrame for the Window */
	private JFrame frame;

	/**
	 * Basic constructor, window defaults to not visible
	 * 
	 * @param title
	 */
	public AbstractSimpleWindow(String title) {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setHgap(300);
		setTitle(title);
		setVisibility(false);
	}
	
	/**
	 * Basic constructor, window's visibility is set to <visible>
	 * 
	 * @param title
	 * @param visible
	 */
	public AbstractSimpleWindow(String title, boolean visible) {
		this(title);
		setVisibility(visible);
		
	}
	
	public void setVisibility(boolean visible) {
		frame.setVisible(visible);
	}
	
	public void setTitle(String title) {
		frame.setTitle(title);
	}
	
	public boolean isVisible() {
		return frame.isVisible();
	}
	
}
