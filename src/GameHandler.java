/**
 * GameHandler Class
 * The GameHandler class contains the main method.
 * GameHandler class creates the JFrame game window that contains all the window components.
 * GameHandler class Creates the scene and player, which takes the game scene.
 * All button actions are handled here.
 * variables:
 * 	WINDOW: A GameWindow object used to create the GUI.
 * 	SCENE: A Scene object used to create the game scene that the Player is in.
 * 	PLAYER: The Player object that navigates through the game.
 * Date: 02 December 2017
 * @authors Team 7
 * @version 1.0
 * @since 1.0
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameHandler
{
	private static final GameWindow WINDOW = new GameWindow();	// Create JFrame.
	private static final Scene SCENE = new Scene(WINDOW.getInformationText(), WINDOW.getBtnUse());	// Create game scene.
	private static final Player PLAYER = new Player(SCENE);	// Create player and pass the scene.
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					WINDOW.getFrame().setVisible(true);
					createActionListeners();
					WINDOW.setSceneImage(SCENE.getScene()); // Set start image.
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}});
		
	}
	
	/**
	 * Create Button Action Listeners.
	 */
	public static void createActionListeners()
	{
		
		// Button listeners.
		WINDOW.getBtnForward().addActionListener(new ActionListener() 
		{

			/**
			 * Move player FORWARD.
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				PLAYER.moveForward();
				WINDOW.setSceneImage(SCENE.getScene());
			}
			
		});
		
		WINDOW.getBtnLeft().addActionListener(new ActionListener() 
		{

			/**
			 * Player turns LEFT.
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				PLAYER.turnLeft();
				WINDOW.setSceneImage(SCENE.getScene());
			}
			
		});
		
		WINDOW.getBtnRight().addActionListener(new ActionListener() 
		{

			/**
			 * Player turns RIGHT.
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				PLAYER.turnRight();
				WINDOW.setSceneImage(SCENE.getScene());
			}
			
		});
		
		WINDOW.getBtnBack().addActionListener(new ActionListener() 
		{

			/**
			 * Move player BACK.
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				PLAYER.moveBack();
				WINDOW.setSceneImage(SCENE.getScene());
			}
			
		});
		
		WINDOW.getBtnPickUp().addActionListener(new ActionListener() 
		{

			/**
			 * Pick up item.
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				PLAYER.pickUp();
			}
			
		});
		
		WINDOW.getBtnUse().addActionListener(new ActionListener()
		{
			/**
			 * Use item.
			 * 
			 * End game if facing entrance and lever is picked up.
			 */
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(PLAYER.hasItem("Lever") && SCENE.getNode() == 1 && SCENE.getDirection() == 3) // END GAME
				{
					// New JPanel:
					JPanel end = new JPanel();
					end.setBounds(0, 0, 600, 600);
					
					JLabel lbl_end = new JLabel();
					lbl_end.setText("YOU ESCAPED!");
					lbl_end.setFont(new Font("Tahoma", Font.PLAIN, 32));
					
					end.add(lbl_end);
					
					//JButton btn_restart = new JButton("");
					//btn_restart.setText("Play Again?");
					
					WINDOW.getFrame().getContentPane().removeAll();
					
					WINDOW.getFrame().getContentPane().add(end);
					
					WINDOW.getFrame().getContentPane().revalidate();
					WINDOW.getFrame().getContentPane().repaint();
				}
				else
					PLAYER.useItem();
			}
		});
	}
}
