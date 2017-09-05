package munk;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class MainWindow {

	private static JFrame frmMunk; //static due to showInputDialog in requestInfoPopup
	public final String munkVersion = "0.1";
	private File saveFile;
	
	private static Committee committee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					committee = new Committee("Untitled Committee");
					MainWindow window = new MainWindow();
					window.frmMunk.setVisible(true);
					window.frmMunk.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMunk = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frmMunk.getContentPane().getLayout();
		borderLayout.setHgap(300);
		frmMunk.setTitle("MUNk " + munkVersion + " | " + committee.getCommitteeName());
		frmMunk.setBounds(100, 100, 450, 300);
		frmMunk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmMunk.getContentPane().add(tabbedPane, BorderLayout.EAST);
		
		JButton startTimer = new JButton("Start Timing!");
		startTimer.setToolTipText("Starts the timer");
		tabbedPane.addTab("Timer", null, startTimer, null);
		
		JList voteInformationGui = new JList();
		tabbedPane.addTab("Voting", null, voteInformationGui, null);
		
		JSplitPane timerPane = new JSplitPane();
		timerPane.setResizeWeight(0.5);
		timerPane.setContinuousLayout(true);
		timerPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frmMunk.getContentPane().add(timerPane, BorderLayout.WEST);
		
		JMenuBar menuBar = new JMenuBar();
		frmMunk.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openFileButton = new JMenuItem("Open file");
		fileMenu.add(openFileButton);
		
		JMenuItem saveMenuButton = new JMenuItem("Save");
		fileMenu.add(saveMenuButton);
		
		JMenuItem saveAsMenuButton = new JMenuItem("Save as...");
		fileMenu.add(saveAsMenuButton);
		
		JMenuItem settingsMenuItem = new JMenuItem("Settings");
		fileMenu.add(settingsMenuItem);
		
		JMenu windowsMenuItem = new JMenu("Windows");
		menuBar.add(windowsMenuItem);
		
		JMenuItem delegatesMenuItem = new JMenuItem("Delegates");
		windowsMenuItem.add(delegatesMenuItem);
		
		JMenuItem resolutionsMenuItem = new JMenuItem("Resolutions");
		windowsMenuItem.add(resolutionsMenuItem);
		
		JMenuItem statisticsMenuItem = new JMenuItem("Statistics");
		windowsMenuItem.add(statisticsMenuItem);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("About");
		helpMenu.add(aboutMenuItem);
		
		JMenuItem changelogMenuItem = new JMenuItem("Changelog");
		helpMenu.add(changelogMenuItem);
	}

  /**
   * Generates a popup requesting a simple String response
   * 
   * @param title title of the popup
   * @param infoRequested Text within the popup giving more information
   * @return a String containing the user's response
   */
  public static String requestSimpleInfoPopup(String title, String infoRequested) {
    
	String requestedInfo = (String)JOptionPane.showInputDialog(frmMunk, infoRequested, title, JOptionPane.PLAIN_MESSAGE);
	  
	return requestedInfo;
    
    
  }
  
  /**
   * Saves the current Committee out to path
   * 
   * @param path path to save the Committee to
   * @throws IOException 
   */
  private static void saveToFile(File file) throws IOException {
	FileOutputStream fileOutputStream = new FileOutputStream(file);
	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	
	objectOutputStream.writeObject(MainWindow.committee);
	
	objectOutputStream.close();
	fileOutputStream.close();

  }
  
  /**
   * Loads the Committee at path into MainWindow.committee
   * 
   * @param path the path to load the Committee from
   * @throws IOException 
   * @throws ClassNotFoundException 
   */
  private static void loadFromFile(File file) throws IOException, ClassNotFoundException {
	  FileInputStream fileInputStream = new FileInputStream(file);
	  ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	  
	  MainWindow.committee = (Committee) objectInputStream.readObject();
	  
	  objectInputStream.close();
	  fileInputStream.close();
	  
  }
  
  /**
   * Make a call to the UI requesting information on what the Committee should be renamed to
   * then renames the Committee to that name. Updates the UI
   */
  private void renameCommittee() {
	  renameCommittee(UIRequestFactory.newCommitteeName());
  }
  
  /**
   * Renames the Committee to the new name, updating the UI.
   * 
   * @param newName
   */
  private void renameCommittee(String newName) {
	  committee.setCommitteeName(newName);
	  frmMunk.setTitle("MUNk" + munkVersion + " | " + newName);
  }
  
  /**
   * Saves the file to the already selected Save File. Selects one
   * from the UI if no save file is selected. 
   */
  private void save() {
	  if (saveFile == null) {
		  saveFile = UIRequestFactory.selectSaveFile();
	  }
	  
	  if (saveFile == null) { //User chose not to select a savefile still
		  try {
		  	saveToFile(saveFile);
	  	} catch (Exception e) {
		  	e.printStackTrace();
	  	}
	  }
  }
  
  /**
   * Resets the selected save file and performs a save
   */
  private void saveAs() {
	  saveFile = null;
	  save();
  }
}
