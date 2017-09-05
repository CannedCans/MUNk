package munk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.Window.Type;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 * A simple GUI window that contains just one Label (for displaying some content), eg. changelogs
 * 
 * @author CannedCans
 *
 */
public class LabelWindow {
	private JFrame windowFrame;
	
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
		
		JLabel label = new JLabel();
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
}
