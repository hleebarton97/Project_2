/**
 * 
 * @author Lee
 *
 */

public class Room 
{
	private String name; // Name of the room.
	private Item item; // All items in the room that cna be picked up.
	
	private boolean locked; 	// Is the room locked or not?
	private boolean hasEntered; // Has the player been to the room or not?
	
// Constructors:
	
	/**
	 * 
	 */
	public Room()
	{
		this.item = new Item();
		this.setName(null);
		this.locked = false;
		this.hasEntered = false;
	}
	
	/**
	 * 
	 * @param name
	 */
	public Room(String name)
	{
		this.item = new Item();
		this.setName(name);
		this.locked = false;
		this.hasEntered = false;
	}

	/**
	 * 
	 * @param name
	 * @param locked
	 */
	public Room(String name, boolean locked)
	{
		this.item = new Item();
		this.setName(name);
		this.setLocked(locked);
		this.hasEntered = false;
	}
	
	
// Getters:
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public Item getItem()
	{
		return this.item;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isLocked()
	{
		return this.locked;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasEntered()
	{
		return this.hasEntered;
	}

	
// Setters:
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @param items
	 */
	public void setItem(Item item)
	{
		this.item = item;
	}
	
	/**
	 * Set item's name after object creation.
	 * 
	 * @param name
	 */
	public void setItemName(String name)
	{
		this.item.setName(name);
	}
	
	/**
	 * Set item's type after object creation.
	 * 
	 * @param type
	 */
	public void setItemType(int type)
	{
		this.item.setType(type);
	}
	
	/**
	 * 
	 * @param locked
	 */
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
	
	/**
	 * 
	 * @param hasEntered
	 */
	public void setHasEntered(boolean hasEntered)
	{
		this.hasEntered = hasEntered;
	}

	
// Functions:
	
	/**
	 * Lock the current room.
	 */
	public void lock()
	{
		this.locked = true;
	}
	
	/**
	 * Unlock the room when a key is used on it.
	 */
	public void unlock()
	{
		this.locked = false;
	}
}
