package munk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

/**
 * A simple GUI window that contains just one Label (for displaying some content), eg. changelogs
 * 
 * @author CannedCans
 *
 */
public class LabelWindow {
	private JFrame windowFrame;
	private JLabel label;
	
	/**
	 * Creates a LabelWindow, setting visible status to visibility
	 * 
	 * @param title title of the window
	 * @param content content of the window
	 * @param visibility
	 */
	public LabelWindow(String title, String content, boolean visibility) {
		initialize(title, content);
		setVisible(visibility);
	}
	
	/**
	 * Creates a LabelWindow, defaulting to visible
	 * 
	 * @param title title of the window
	 * @param content content of the window
	 */
	public LabelWindow(String title, String content) {
		initialize(title, content);
		setVisible(true);
	}
	
	/**
	 * Generates the frame's content
	 * 
	 * @param title title of the window
	 * @param content content of the window
	 */
	public void initialize(String title, String content) {
		windowFrame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) windowFrame.getContentPane().getLayout();
		borderLayout.setHgap(300);
		windowFrame.setTitle(title);
		windowFrame.setBounds(100, 100, 450, 300);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel();
		label.setText(content);
		
		windowFrame.getContentPane().add(label, BorderLayout.NORTH);
		
	}
	
	/**
	 * Set the visible status of the LabelWindow to visibility
	 * 
	 * @param visibility
	 */
	public void setVisible(boolean visibility) {
		windowFrame.setVisible(visibility);
	}
	
	/**
	 * Set the title of the window to title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		windowFrame.setTitle(title);
	}
	
	/**
	 * Set the content of the window's label to title
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		label.setText(content);
	}
}
