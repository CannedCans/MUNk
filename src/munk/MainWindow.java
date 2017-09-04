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
import java.nio.file.Path;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;

public class MainWindow {

	private JFrame frmMunk;
	public final String munkVersion = "0.1";
	private Path savePath;
	
	private static Committee committee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmMunk.setVisible(true);
					window.frmMunk.setExtendedState(JFrame.MAXIMIZED_BOTH);
					committee = new Committee();
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
		frmMunk.setTitle("MUNk " + munkVersion);
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
	}

  public static String requestInfoPopup(String title, String infoRequested) {
    return "FILLER TEXT";
  }
}
