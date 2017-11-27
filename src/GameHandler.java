import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameHandler 
{
	private static final GameWindow WINDOW = new GameWindow();	// Create JFrame.
	private static final Scene SCENE = new Scene(WINDOW.getInformationText());	// Create game scene.
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
			}
			
		});
	}
}
