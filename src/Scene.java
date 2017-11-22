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
import javax.imageio.ImageIO;

public class Scene 
{
	private int node;			 // The digit value of the scene the player is currently on (0 - 10).
	private int dir;			 // The direction the player is facing at node position (0 - 3).
	private BufferedImage scene; // Actual image of the scene.
	
	/**
	 * Constructor that doesn't take a node value and sets the scene
	 * at the start.
	 */
	public Scene()
	{
		this.setNode(0);
		this.setDirection(0);
	}
	
	/**
	 * Constructor that takes in a node value and sets the scene.
	 * @param node, dir
	 */
	public Scene(int node, int dir)
	{
		this.setNode(node);
		this.setDirection(dir);
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
	 * Update player's current direction and position.
	 * @param node
	 * @param dir
	 */
	public void updateScene(int node, int dir)
	{
		this.node = node;
		this.dir = dir;
		this.loadImage();
	}

// Functions
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_2_Hallway.png"));
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_4_Hallway.png"));
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_5_Hallway.png"));
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_7_Hallway.png"));
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_8_Hallway.png"));
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_9_Hallway.png"));
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
				this.scene = ImageIO.read(new File("src/assets/img", "node_10_Hallway.png"));
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("Error loading image [scene " + this.node + "]");
			}
		}
	}
	
}
