/**
 * GameWindow Class
 * The GameWindow class creates the GUI that allows a user to navigate through
 * the game with a Player character and interact with Item objects.
 * fields:
 * 	bg: A JLabel object that is used to hold the scene attributes.
 * 	btn_Back: A JButton object that is used to hold the attributes that represent a "Back" button in the game.
 * 	btn_Forward: A JButton object that is used to hold the attributes that represent a "Forward" button in the game.
 * 	btn_Left: A JButton object that is used to hold the attributes that represent a "Turn Left" button in the game.
 * 	btn_Pickup: A JButton object that is used to hold the attributes that represent a "Pickup Item" button in the game.
 * 	btn_Right: A JButton object that is used to hold the attributes that represent a "Turn Right" button in the game.
 * 	btn_Use: A JButton object that is used to hold the attributes that represent a "Use Item" button in the game.
 * 	frame: A JFram object used to hold the GUI components
 * 	ii: An ImageIcon object used to hold a scene image
 * 	panel_Buttons: A JPanel object used to hold all JButtons
 * 	panel_Information: A JPanel object used to hold the information that will be displayed to the Player.
 * 	panel_Inventory: A JPanel object used to hold a Player's Inventory
 * 	txt_Information: A JtextPane object used to hold information that corresponds to the lore of the game.
 * Date: 02 December 2017
 * OOP Project 2: The Mansion
 * @author Team 7
 * @version 1.0
 * @since 1.0
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Rectangle;
import net.miginfocom.swing.MigLayout;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Font;

public class GameWindow {

	private JFrame frame; // to hold the GUI components
	
	private JLabel bg; // to hold the attributes of a scene
	private ImageIcon ii; // to hold an image for a scene
	
	private JPanel panel_Information, // to hold the information to be displayed to the Player
		   panel_Inventory, // to hold a Player's inventory of Items
		   panel_Buttons; // to hold the JButtons
	
	private JTextPane txt_Information; // to hold information regarding the lore of the game.
	
	// these buttons are used to allow the Player to move and interact within the game.
	private JButton btn_PickUp,
		    btn_Forward,
		    btn_Back,
		    btn_Left,
		    btn_Right,
		    btn_Use;

	/**
	 * The constructor calls the initialize method which
	 * in turn creates the GUI.
	 */
	public GameWindow() 
	{
		initialize();
	}

	/**
	 * The initialize method creates the required JPanels, JTextPane,
	 * JButtons, JLabel, and ImageIcon that are used in the GUI and
	 * adds them to the JFrame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("The Mansion");
		
		this.panel_Information = new JPanel();
		panel_Information.setBounds(370, 11, 204, 300);
		frame.getContentPane().add(panel_Information);
		panel_Information.setLayout(null);
		
		this.txt_Information = new JTextPane();
		txt_Information.setEditable(false);
		txt_Information.setRequestFocusEnabled(false);
		txt_Information.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txt_Information.setBounds(10, 29, 184, 260);
		panel_Information.add(txt_Information);
		
		this.bg = new JLabel();
		
		JLabel lbl_Information = new JLabel("Information");
		lbl_Information.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Information.setBounds(10, 0, 184, 30);
		panel_Information.add(lbl_Information);
		
		this.panel_Inventory = new JPanel();
		panel_Inventory.setBounds(10, 322, 204, 228);
		frame.getContentPane().add(panel_Inventory);
		panel_Inventory.setLayout(null);
		
		JLabel lbl_Inventory = new JLabel("Inventory");
		lbl_Inventory.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Inventory.setBounds(10, 0, 184, 30);
		panel_Inventory.add(lbl_Inventory);
		
		this.btn_Use = new JButton("");
		btn_Use.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Use.setBounds(10, 31, 184, 186);
		panel_Inventory.add(btn_Use);
		
		this.panel_Buttons = new JPanel();
		panel_Buttons.setBounds(224, 322, 350, 228);
		frame.getContentPane().add(panel_Buttons);
		panel_Buttons.setLayout(new MigLayout("", "[70px][70px][70px][70px][70px]", "[45px][45px][45px][45px][45px]"));
		
		JLabel label_1 = new JLabel("");
		panel_Buttons.add(label_1, "cell 1 0,grow");
		
		JLabel label_2 = new JLabel("");
		panel_Buttons.add(label_2, "cell 2 0,grow");
		
		JLabel label_3 = new JLabel("");
		panel_Buttons.add(label_3, "cell 3 0,grow");
		
		JLabel label_4 = new JLabel("");
		panel_Buttons.add(label_4, "cell 4 0,grow");
		
		JLabel label_5 = new JLabel("");
		panel_Buttons.add(label_5, "cell 0 1,grow");
		
		JLabel label_6 = new JLabel("");
		panel_Buttons.add(label_6, "cell 1 1,grow");
		
		this.btn_Forward = new JButton("Forward");
		btn_Forward.setBounds(new Rectangle(0, 0, 90, 30));
		panel_Buttons.add(btn_Forward, "cell 2 1,grow");
		
		this.btn_Left = new JButton("Left");
		panel_Buttons.add(btn_Left, "cell 1 2,grow");
		
		this.btn_PickUp = new JButton("Pick Up");
		panel_Buttons.add(btn_PickUp, "cell 2 2,grow");
		
		this.btn_Right = new JButton("Right");
		panel_Buttons.add(btn_Right, "cell 3 2,grow");
		
		JLabel label_10 = new JLabel("");
		panel_Buttons.add(label_10, "cell 4 2,grow");
		
		JLabel label_11 = new JLabel("");
		panel_Buttons.add(label_11, "cell 0 3,grow");
		
		JLabel label_12 = new JLabel("");
		panel_Buttons.add(label_12, "cell 1 3,grow");
		
		this.btn_Back = new JButton("Back");
		panel_Buttons.add(btn_Back, "cell 2 3,grow");
		
		JLabel label_13 = new JLabel("");
		panel_Buttons.add(label_13, "cell 3 3,grow");
		
		JLabel label_14 = new JLabel("");
		panel_Buttons.add(label_14, "cell 4 3,grow");
		
		JLabel label_15 = new JLabel("");
		panel_Buttons.add(label_15, "cell 0 4,grow");
		
		JLabel label_16 = new JLabel("");
		panel_Buttons.add(label_16, "cell 1 4,grow");
		
		JLabel label_17 = new JLabel("");
		panel_Buttons.add(label_17, "cell 2 4,grow");
		
		JLabel label_18 = new JLabel("");
		panel_Buttons.add(label_18, "cell 3 4,grow");
		
		JLabel label_19 = new JLabel("");
		panel_Buttons.add(label_19, "cell 4 4,grow");
		
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	// JFrame Getter
	public JFrame getFrame()
	{
		return this.frame;
	}
	
	
	// JPanel Getters
	public JPanel getInformationPanel()
	{
		return this.panel_Information;
	}

	public JPanel getInventoryPanel()
	{
		return this.panel_Inventory;
	}
	
	public JPanel getButtonPanel()
	{
		return this.panel_Buttons;
	}
	
	
	// JTextPane Getter
	public JTextPane getInformationText()
	{
		return this.txt_Information;
	}
	
	
	// JButton Getters
	public JButton getBtnPickUp()
	{
		return this.btn_PickUp;
	}
	
	public JButton getBtnForward()
	{
		return this.btn_Forward;
	}

	public JButton getBtnLeft()
	{
		return this.btn_Left;
	}

	public JButton getBtnRight()
	{
		return this.btn_Right;
	}

	public JButton getBtnBack()
	{
		return this.btn_Back;
	}

	public JButton getBtnUse()
	{
		return this.btn_Use;
	}
	
	/**
	 * The setSceneImage method sets the image of the current scene.
	 * @param img The image to be added to the ImageIcon
	 */
	public void setSceneImage(BufferedImage img)
	{
		this.bg.setBounds(10, 11, 350, 300); // Set image bounds and size.
		this.bg.setIcon(new ImageIcon(img)); // Set the background of JLabel.
		this.frame.getContentPane().add(bg); // Add JLabel to our game window.
	}
}
