/**
 * 
 * @author Lee
 *
 */

import java.util.ArrayList;

public class Player
{
	private ArrayList<Item> items;	// Items in player's inventory.
	private Scene scene;	// Scene player is current on.
    
	/**
	 * 
	 * @param scene
	 */
    public Player(Scene scene)
    {
        this.items = new ArrayList<Item>();
        this.scene = scene;
    }
    
    /**
     * 
     * @param items
     * @param scene
     */
    public Player(ArrayList<Item> items, Scene scene)
    {
    	this.setItems(items);
    	this.scene = scene;
    }

    
// Getters: 
    
    /**
     * 
     * @return
     */
    public ArrayList<Item> getItems()
    {
        return this.items;
    }
    
    
// Setters:
    
    /**
     * 
     * @param items
     */
    public void setItems(ArrayList<Item> items)
    {
    	this.items = items;
    }
    
    
// Actions:
    
    /**
     * Player moves forward based on current position and direction.
     */
    public void moveForward()
    {
    	/**
    	 * Check current position and then update based on current position.
    	 */
    	if(this.scene.getNode() == 0) // STARTING POSITION.
    		this.scene.updateScene(1, 0);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 0) // NODE 1 FACING FORWARD.
    		this.scene.updateScene(3, 0);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 1) // NODE 1 FACING LOUNGE (LEFT).
    		this.scene.updateScene(2, 0);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 2) // NODE 1 FACING STUDY (RIGHT).
    	{
    		if(!(this.scene.getRoomByName("Study").isLocked())) // If the room is unlocked.
    			this.scene.updateScene(4, 0);
    		else
    			this.scene.getInfo().writeInformation("The door is locked.");
    	}
    	//else if(this.scene.getNode() == 1 && this.scene.getDirection() == 3) // NODE 1 FACING ENTRANCE (BACK).
    		// Can't move.
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 0) // NODE 3 FACING FORWARD.
    		this.scene.updateScene(6, 0);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 1) // NODE 3 FACING BILLIARD ROOM (LEFT).
    	{
    		if(!(this.scene.getRoomByName("Billiard Room").isLocked())) // If the room is unlocked.
    			this.scene.updateScene(7, 0);
    		else
    			this.scene.getInfo().writeInformation("The door is locked.");
    	}
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 2) // NODE 3 FACING BALLROOM (RIGHT).
    	{
    		if(!(this.scene.getRoomByName("Billiard Room").isLocked())) // If the room is unlocked.
    			this.scene.updateScene(5, 0);
    		else
    			this.scene.getInfo().writeInformation("The door is locked.");
    			
    	}
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 3) // NODE 3 FACING NODE 1 (BACK).
    		this.scene.updateScene(1, 3);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 0) // NODE 6 FACING CONSERVATORY (FORWARD).
    	{
    		if(!(this.scene.getRoomByName("Conservatory").isLocked())) // If the room is unlocked.
    			this.scene.updateScene(9, 0);
    		else
    			this.scene.getInfo().writeInformation("The door is locked.");
    	}
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 1) // NODE 6 FACING LIBRARY (LEFT).
    	{
    		if(!(this.scene.getRoomByName("Library").isLocked()))
    			this.scene.updateScene(8, 0);
    		else
    			this.scene.getInfo().writeInformation("The room is too dark to enter.");
    	}
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 2) // NODE 6 FACING KITCHEN (RIGHT).
    	{
    		if(!(this.scene.getRoomByName("Kitchen").isLocked()))
    			this.scene.updateScene(10, 0);
    		else
    			this.scene.getInfo().writeInformation("The door is locked.");
    	}
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 3) // NODE 6 FACING NODE 3 (BACK).
    		this.scene.updateScene(3, 3);
    }
    
    /**
     * Player turns left based on current position and direction.
     */
    public void turnLeft()
    {
    	/**
    	 * Check position and direction and turn based on position and direction.
    	 */
    	if(this.scene.getNode() == 1 && this.scene.getDirection() == 0) 		// NODE 1 FACING NODE 3.
    		this.scene.updateScene(1, 1);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 1)	// NODE 1 FACING LOUNGE.
    		this.scene.updateScene(1, 3);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 2)	// NODE 1 FACING STUDY.
    		this.scene.updateScene(1, 0);	
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 3)	// NODE 1 FACING ENTRANCE.
    		this.scene.updateScene(1, 2);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 0)	// NODE 3 FACING NODE 6.
    		this.scene.updateScene(3, 1);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 1)	// NODE 3 FACING BILLIARD ROOM.
    		this.scene.updateScene(3, 3);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 2)	// NODE 3 FACING BALLROOM.
    		this.scene.updateScene(3, 0);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 3)	// NODE 3 FACING NODE 1.
    		this.scene.updateScene(3, 2);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 0)	// NODE 6 FACING CONSERVATORY.
    		this.scene.updateScene(6, 1);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 1)	// NODE 6 FACING LIBRARY.
    		this.scene.updateScene(6, 3);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 2)	// NODE 6 FACING KITCHEN.
    		this.scene.updateScene(6, 0);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 3)	// NODE 6 FACING NODE 3.
    		this.scene.updateScene(6, 2);
    }
    
    /**
     * Player turns right based on current position and direction.
     */
    public void turnRight()
    {
    	/**
    	 * Check position and direction and turn based on position and direction.
    	 */
    	if(this.scene.getNode() == 1 && this.scene.getDirection() == 0) 		// NODE 1 FACING NODE 3.
    		this.scene.updateScene(1, 2);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 1)	// NODE 1 FACING LOUNGE.
    		this.scene.updateScene(1, 0);
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 2)	// NODE 1 FACING STUDY.
    		this.scene.updateScene(1, 3);	
    	else if(this.scene.getNode() == 1 && this.scene.getDirection() == 3)	// NODE 1 FACING ENTRANCE.
    		this.scene.updateScene(1, 1);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 0)	// NODE 3 FACING NODE 6.
    		this.scene.updateScene(3, 2);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 1)	// NODE 3 FACING BILLIARD ROOM.
    		this.scene.updateScene(3, 0);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 2)	// NODE 3 FACING BALLROOM.
    		this.scene.updateScene(3, 3);
    	else if(this.scene.getNode() == 3 && this.scene.getDirection() == 3)	// NODE 3 FACING NODE 1.
    		this.scene.updateScene(3, 1);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 0)	// NODE 6 FACING CONSERVATORY.
    		this.scene.updateScene(6, 2);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 1)	// NODE 6 FACING LIBRARY.
    		this.scene.updateScene(6, 0);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 2)	// NODE 6 FACING KITCHEN.
    		this.scene.updateScene(6, 3);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 3)	// NODE 6 FACING NODE 3.
    		this.scene.updateScene(6, 1);
    }
    
    /**
     * Player moves back based on current position and direction.
     */
    public void moveBack()
    {
    	//if(this.scene.getNode() == 1 && this.scene.getDirection() == 0) // NODE 1 FACING AWAY FROM ENTRANCE
    		// CAN'T MOVE.
    	if(this.scene.getNode() == 3 && this.scene.getDirection() == 0) // NODE 3 FACING AWAY FROM NODE 1.
    		this.scene.updateScene(1, 0);
    	else if(this.scene.getNode() == 6 && this.scene.getDirection() == 0) // NODE 6 FACING AWAY FROM NODE 3.
    		this.scene.updateScene(3, 0);
    	else if(this.scene.getNode() == 2 && this.scene.getDirection() == 0) // NODE 2 IN LOUNGE.
    		this.scene.updateScene(1, 1);
    	else if(this.scene.getNode() == 4 && this.scene.getDirection() == 0) // NODE 4 IN STUDY.
    		this.scene.updateScene(1, 2);
    	else if(this.scene.getNode() == 7 && this.scene.getDirection() == 0) // NODE 7 IN BILLIARD ROOM.
    		this.scene.updateScene(3, 1);
    	else if(this.scene.getNode() == 5 && this.scene.getDirection() == 0) // NODE 5 IN BALLROOM.
    		this.scene.updateScene(3, 2);
    	else if(this.scene.getNode() == 8 && this.scene.getDirection() == 0) // NODE 8 IN LIBRARY.
    		this.scene.updateScene(6, 1);
    	else if(this.scene.getNode() == 10 && this.scene.getDirection() == 0) // NODE 10 IN KITCHEN.
    		this.scene.updateScene(6, 2);
    	else if(this.scene.getNode() == 9 && this.scene.getDirection() == 0) // NODE 9 IN CONSERVATORY.
    		this.scene.updateScene(6, 0);
    	
    }
    
    /**
     * Player picks up item if item exists.
     */
    public void pickUp()
    {
    	// Get room player is in.
    	Room room = this.scene.getRoomByPosition();
    	
    	// If the player is not in the hallway.
    	if(!(room.getName().equals("Hallway")))
    	{
    		// If item has not been picked up, then pick it up.
    		if(!(room.getItem().isPickedUp()))
    		{
	    		// Add item to player's inventory.
	    		this.items.add(room.getItem());
	    		
	    		// Item has now been picked up.
	    		room.getItem().setPickedUp(true);
    		}
    	}
    }
}
