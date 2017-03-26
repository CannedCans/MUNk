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
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class MainWindow {

	private JFrame frmMunk;
	public final String munkVersion = "0.1";

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
	}
	
}
