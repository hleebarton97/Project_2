/**
 * Room Class
 * The Room class contains fields and methods needed to create a room within the game.
 * fields:
 * 	hasEntered: A boolean used to hold the state of whether the player has entered the room or not.
 * 	item: An Item object in a room that can be picked up by the Player.
 * 	locked: A boolean used to hold the state of whether or not a room is locked.
 * 	name: A String that holds the name of the room.
 * Date: 02 December 2017
 * OOP Project 2: The Mansion
 * @author Team 7
 *
 */

public class Room 
{
	private String name; // Name of the room.
	private Item item; // All items in the room that can be picked up.
	
	private boolean locked; 	// Is the room locked or not?
	private boolean hasEntered; // Has the player been to the room or not?

	/**
	 * The default constructor creates a room object
	 * with default values.
	 */
	public Room()
	{
		this.item = new Item();
		this.setName(null);
		this.locked = false;
		this.hasEntered = false;
	}
	
	/**
	 * This constructor creates a room object, storing the value in the
	 * name parameter into the name field.
	 * @param name The value to be stored in the name field.
	 */
	public Room(String name)
	{
		this.item = new Item();
		this.setName(name);
		this.locked = false;
		this.hasEntered = false;
	}

	/**
	 * This constructor creates a room based on it's name and whether
	 * or not the room is locked.
	 * @param name The value to be stored in the name field.
	 * @param locked The value to be stored in the locked field.
	 */
	public Room(String name, boolean locked)
	{
		this.item = new Item();
		this.setName(name);
		this.setLocked(locked);
		this.hasEntered = false;
	}
	
	
	// Getters:
	public String getName()
	{
		return this.name;
	}

	public Item getItem()
	{
		return this.item;
	}

	public boolean isLocked()
	{
		return this.locked;
	}

	public boolean hasEntered()
	{
		return this.hasEntered;
	}

	
	// Setters:
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setItem(Item item)
	{
		this.item = item;
	}

	public void setItemName(String name)
	{
		this.item.setName(name);
	}
	
	/**
	 * The setItemType sets an int value that is used to determine
	 * which node the player can use that item on.
	 * @param type The integer value that represents which node
	 * 			this item can be used on.
	 */
	public void setItemType(int type)
	{
		this.item.setType(type);
	}
	

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	
	public void setHasEntered(boolean hasEntered)
	{
		this.hasEntered = hasEntered;
	}

	
	// Operations:
	
	/**
	 * The lock method locks the current room.
	 */
	public void lock()
	{
		this.locked = true;
	}
	
	/**
	 * The unlock method unlocks the room when a key is used on it.
	 */
	public void unlock()
	{
		this.locked = false;
	}
}
