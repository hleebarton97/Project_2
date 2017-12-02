/**
 * The Scene class keeps track of the player's position (node)
 * and the direction they are facing (dir).
 * 
 * This class also loads the images based on the player's position
 * and direction and is used to update them into the game.
 *
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JTextPane;

public class Scene 
{
	private int node;			 	// The digit value of the scene the player is currently on (0 - 10).
	private int dir;			 	// The direction the player is facing at node position (0 - 3).
	private int type; 				// Handles different information at the same node and direction.
	private BufferedImage scene; 	// Actual image of the scene.
	
	private Information info;	 	// The information provided for each scene.
	
	private ArrayList<Room> rooms; 	// ArrayList of the 8 rooms.
	
	/**
	 * Constructor that doesn't take a node value and sets the scene
	 * at the start.
	 */
	public Scene(JTextPane windowText)
	{
		this.setNode(0); 		 		// Default node position at 0.
		this.setDirection(0);	 		// Default direction at 0.
		this.setType(0);				// Default type of information.
		this.info = new Information(windowText); // Create information object.
		createRooms(); // Create room objects.
	}
	
	/**
	 * Constructor that takes in a node value and sets the scene.
	 * @param node, dir, JTextPane
	 */
	public Scene(int node, int dir, JTextPane windowText)
	{
		this.setNode(node);				// Set node position.
		this.setDirection(dir);			// Set dir.
		this.setType(0);				// Set type.
		this.info = new Information(windowText); // Create information object.
		createRooms(); // Create room objects.
	}

	
// Getters
	
	/**
	 * Get the current value of the node.
	 * @return value of node.
	 */
	public int getNode()
	{
		return this.node;
	}
	
	/**
	 * Get the current direction the player is facing.
	 * @return value of dir.
	 */
	public int getDirection()
	{
		return this.dir;
	}
	
	/**
	 * Get the current type of information that is being displayed.
	 * @return
	 */
	public int getType()
	{
		return this.type;
	}
	
	/**
	 * Get the current scene image.
	 * @return image of the scene.
	 */
	public BufferedImage getScene()
	{
		return this.scene;
	}

	
// Setters
	
	/**
	 * Set the value of node.
	 * @param node -- Value of scene that the player is on.
	 */
	public void setNode(int node)
	{
		this.node = node;
		this.loadImage();
	}
	
	/**
	 * Set the value of dir.
	 * @param dir --  Value of direction that the player is facing at current node.
	 */
	public void setDirection(int dir)
	{
		this.dir = dir;
		this.loadImage();
	}
	
	/**
	 * Set the value of type.
	 * @param type
	 */
	public void setType(int type)
	{
		this.type = type;
	}
	
	/**
	 * Update player's current direction and position.
	 * @param node
	 * @param dir
	 */
	public void updateScene(int node, int dir)
	{
		this.node = node;
		this.dir = dir;
		this.setInformation(node, dir);
		this.updateRoom(node);
		this.loadImage();
	}

// Functions
	
	/**
	 * Set the appropriate information based on multiple variables.
	 * @param node
	 * @param dir
	 */
	public void setInformation(int node, int dir)
	{
		if(node == 1) // Check NODE 1 type.
		{
			if(this.dir == 0 && this.getRoomByName("Hallway").hasEntered())
				this.setType(1);
			else if(this.dir == 2 && this.getRoomByName("Study").isLocked()) // Study is unlocked.
				this.setType(1);
			else
				this.setType(0);	
		}
		else
			this.setType(0);
		
		this.info.updateInformation(node, dir, this.type);
	}
	
	public Room getRoomByName(String name)
	{
		for(Room room : this.rooms)
		{
			if(room.getName().equals(name))
				return room;
		}
		return null;
	}
	
	public void updateRoom(int node)
	{
		if(node == 1)
			this.getRoomByName("Hallway").setHasEntered(true);
		else if(node == 2)
			this.getRoomByName("Lounge").setHasEntered(true);
		else if(node == 4)
			this.getRoomByName("Study").setHasEntered(true);
		else if(node == 5)
			this.getRoomByName("Ballroom").setHasEntered(true);
		else if(node == 7)
			this.getRoomByName("Billiard Room").setHasEntered(true);
		else if(node == 8)
			this.getRoomByName("Library").setHasEntered(true);
		else if(node == 9)
			this.getRoomByName("Conservatory").setHasEntered(true);
		else if(node == 10)
			this.getRoomByName("Kitchen").setHasEntered(true);
		
	}
	
	/**
	 * 
	 */
	public void createRooms()
	{
		rooms = new ArrayList<Room>();	// Initialize rooms ArrayList.
		
		Room lounge = new Room("Lounge");
		Room billiard = new Room("Billiard Room");
		Room library = new Room("Library");
		Room study = new Room("Study");
		Room ballroom = new Room("Ballroom");
		Room kitchen = new Room("Kitchen");
		Room conservatory = new Room("Conservatory");
		Room hallway = new Room("Hallway");
		
		this.rooms.add(lounge);
		this.rooms.add(billiard);
		this.rooms.add(library);
		this.rooms.add(study);
		this.rooms.add(ballroom);
		this.rooms.add(kitchen);
		this.rooms.add(conservatory);
		this.rooms.add(hallway);
	}
	
	public void printNodeDir()
	{
		System.out.println("Position: " + this.node + ", Dir: " + this.dir);
	}
	
	/**
	 * Load an image and set this.scene to the loaded image
	 * based on the player's position (this.node).
	 */
	private void loadImage()
	{
		if(this.node == 0) // START.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_0_Mansion.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 1 && this.dir == 0) // Hallway facing forward.
		{
			try 
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_1_0_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 1 && this.dir == 1) // Hallway facing left (door of Lounge).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_1_1_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 1 && this.dir == 2) // Hallway facing right (door of Study).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_1_2_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 1 && this.dir == 3) // Hallway facing entrance.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_1_3_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 2) // THE LOUNGE.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_2_Lounge.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 3 && this.dir == 0) // Hallway middle facing forward.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_3_0_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 3 && this.dir == 1) // Hallway middle facing left (door of Billiard Room).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_3_1_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 3 && this.dir == 2) // Hallway middle facing right (door of Ballroom).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_3_2_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		if(this.node == 3 && this.dir == 3) // Hallway middle facing entrance.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_3_3_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 4) // THE STUDY.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_4_Study.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 5) // THE BALLROOM.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_5_Ballroom.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 6 && this.dir == 0) // Hallway end facing forward (door to Conservatory).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_6_0_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 6 && this.dir == 1) // Hallway end facing left. (door to Library).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_6_1_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 6 && this.dir == 2) // Hallway end facing right. (door to Kitchen).
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_6_2_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 6 && this.dir == 3) // Hallway end facing entrance.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_6_3_Hallway.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 7) // BILLIARD ROOM.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_7_Billiard.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 8) // LIBRARY.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_8_Library.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 9) // CONSERVATORY.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_9_Conservatory.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
		else if(this.node == 10) // KITCHEN.
		{
			try
			{
				this.scene = ImageIO.read(new File("src/assets/img", "node_10_Kitchen.png"));
				this.printNodeDir();
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
	}
	
}
