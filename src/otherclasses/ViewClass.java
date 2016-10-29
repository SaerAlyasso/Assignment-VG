package otherclasses;





import otherclasses.PlayerMethods;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * This class implements the interface ActionListener. In this class
 * a frame, a label and buttons are created and some actions are added
 * to the buttons when they are clicked.
 *  
 * @author Saer Alyasso
 * @version 1.0
 * @since 2016-10-24
 */

public class ViewClass implements ActionListener {

	// creating PlayerMethods object
	PlayerMethods playerMehtods = new PlayerMethods();

	//creating a file chooser
	 final JFileChooser fileChooser = new JFileChooser();
	
	//creating a filter to the JFileChooser fileChooser
	 private FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3 files","mp3");
	
	// creating frame, label and buttons	
	private JFrame frame = new JFrame();
	private JLabel musicLabel = new JLabel("Music: ");
	private JButton openButton = new JButton();
	private JButton playButton = new JButton();
	private JButton pauseButton = new JButton();
	private JButton stopButton = new JButton();
	
	
		
	/**
	 * Constructor. This constructor calls the method createGUI when creating
	 * a ViewClass object in Main class.
	 */
	public ViewClass() {
		createGUI();
		addActionListeners();
		
	}
	
	/**
	 * This method sets the  properties for the frame and the contents.
	 */
	public void createGUI() {
		
		// setting properties of the frame
		frame.getContentPane().setBackground(UIManager.getColor("controlDkShadow"));
		frame.setBounds(100, 100, 563, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("My music player");
		
		// setting images for buttons	
		openButton.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/Icons/openp.jpg")));
		playButton.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/Icons/playp.jpg")));
		pauseButton.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/Icons/pausep.jpg")));
		stopButton.setIcon(new ImageIcon(ViewClass.class.getResource("/resources/Icons/stopp.jpg")));

		// setting colors for the buttons
		openButton.setBackground(Color.white);
		playButton.setBackground(Color.white);
		pauseButton.setBackground(Color.white);
		stopButton.setBackground(Color.white);
		
		// setting properties for label and buttons
		musicLabel.setBounds(22, 35, 507, 25);
		openButton.setBounds(22, 109, 82, 25);
		playButton.setBounds(162, 109, 82, 25);
		pauseButton.setBounds(299, 109, 82, 25);
		stopButton.setBounds(447, 109, 82, 25);
		
		// adding player,label and buttons to the frame
		frame.getContentPane().add(playerMehtods.getPlayer());
		frame.getContentPane().add(musicLabel);
		frame.getContentPane().add(openButton);
		frame.getContentPane().add(playButton);
		frame.getContentPane().add(pauseButton);
		frame.getContentPane().add(stopButton);
		
		//setting the created filter to fileChooser
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		
		
		frame.setVisible(true);
	}
	
	/**
	 * This method register an instance of the event handler class
	 * as a listener on the components added below.
	 */
	public void addActionListeners(){
		
		openButton.addActionListener(this);
		playButton.addActionListener(this);
		pauseButton.addActionListener(this);
		stopButton.addActionListener(this);
	}
	
	/**
	 * actionPerformed is a method in listener interface. Here we write code
	 * that reacts to the action. ActionEvent e gives information about the 
	 * event and its source.
	 */
	public void actionPerformed(ActionEvent e){
		
		
		
		// if you click on open
		if(e.getSource()== openButton){
			if(playerMehtods.getPlayer().getPlayList().size()!=0){
				playerMehtods.getPlayer().stop();		
			}
			
			int returnval = fileChooser.showOpenDialog(frame);
			if(returnval==JFileChooser.APPROVE_OPTION){
				File file = fileChooser.getSelectedFile();
				musicLabel.setText("Music: "+file.getName());
				playerMehtods.open(file);
		
			}
			
			
		}
		
		// if you click on play
		if(e.getSource()== playButton){
			playerMehtods.play();
			
		}
		
		// if you click on pause
		if(e.getSource()== pauseButton){
			playerMehtods.pause();
			
		}
		
		// if you click on stop
		if(e.getSource()== stopButton){
			playerMehtods.stop();
		}
	}
}
