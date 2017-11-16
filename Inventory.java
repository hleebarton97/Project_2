import java.util.ArrayList;

/**
	The Inventory class allows Item objects to be added to and
	removed from an ArrayList.
	@author Ryan Hallberg
	@since 1.0
	@version 1.0
*/

public class Inventory
{
	// field: An ArrayList of Item objects
	private ArrayList<Item> itemList;
	
	/**
	 * The constructor creates an ArrayList of Item objects
	 */
	public Inventory()
	{
		itemList = new ArrayList<>();
	}
	
	/**
	 * The copy constructor copies an ArrayList of Items
	 * @param obj The Inventory object to be copied
	 */
	public Inventory(Inventory obj)
	{
		for (Item i : obj.itemList)
			this.itemList.add(i);
	}
	
	// setters
	/**
	 * The addItem method adds an Item to the itemList.
	 * @param obj The Item object to be added to
	 * 			itemList.
	 */
	public void addItem(Item obj)
	{
		itemList.add(obj);
	}
	
	/**
	 * The removeItem method removes an Item object from
	 * itemList.
	 * @param obj The Item object to be removed from
	 * 			itemList.
	 */
	public void removeItem(Item obj)
	{
		for (int i = 0; i < itemList.size(); i++)
			if (itemList.get(i).getItemName().equals(obj.getItemName()))
				itemList.remove(i);
	}
	
	/**
	 * The toString method creates a String object
	 * containing all the Item objects in itemList.
	 * @return str A String object containing the
	 * 			names and quantity's of an Item
	 * 			object and the total number of
	 * 			Item objects in itemList.
	 */
	public String toString()
	{
		String str = "";
		for (Item itm : itemList)
		{
			str += "Item Name: " + itm.getItemName() + "\n"
					+ "Quantity: " + itm.getItemQuantity() + "\n";
		}
		
		str += "Total Number of Items: " + itemList.size();
		
		return str;
	}
}
