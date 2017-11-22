import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameHandler 
{
	private static final GameWindow WINDOW = new GameWindow();
	private static final Scene SCENE = new Scene();
	private static final Information INFO = new Information(WINDOW.getInformationText());
	
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
				INFO.writeInformation("Left");
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
				System.out.println("BUTTON RIGHT!");
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
				System.out.println("BUTTON BACK!");
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
				System.out.println("BUTTON PICKUP!");
			}
			
		});
	}
}
