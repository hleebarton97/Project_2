/**
 * Information Class
 * The Information class uses a JTextPane to handle information
 * that is to be displayed to the viewer. This is what creates
 * the lore of the game.
 * fields:
 * 	infoPane: A JTextPane object used to hold and display information to the Player.
 * Information class reads from the src/assets/info/info.dat file
 * Date: 02 December 2017
 * OOP Project 2: The Mansion
 * @author Team 7
 * @version 1.0
 * @since 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JTextPane;

public class Information 
{
	
	private JTextPane infoPane;	// Our JTextPane to write information to.
    
	/**
	 * This constructor accepts a JTextPane object and uses it to
	 * set the information to be displayed in the JTextPane 
	 * @param infoPane The JTextPane whose information is to be updated.
	 */
    public Information(JTextPane infoPane)
    {
        this.setInformationPanel(infoPane); // add the current JTextPane to the JFrame.
        this.updateInformation(0, 0, 0); 	// Start of game information.
    }
    
    
    // Setter:
    /**
     * The setInformationPanel method sets the copies the infoPane
     * parameter and stores it in the infoPane field.
     * @param infoPane The JTextPane to be copied into the infoPane field.
     */
    public void setInformationPanel(JTextPane infoPane)
    {
    	this.infoPane = infoPane;
    }
    

    // Getter:
    /**
     * The getInformationPanel gets the current JTextPane.
     * @return A reference to the JTextPane in the infoPane field.
     */
    public JTextPane getInformationPanel()
    {
        return this.infoPane;
    }
    

    // Functions:
    /**
     * The writeInformation method sets the text in the JTextPane
     * referenced by infoPane.
     * @param info The text to be set in infoPane.
     */
    public void writeInformation(String info)
    {
        this.infoPane.setText(info);
    }
    
    /**
     * The getInformationFromFile method reads the information from the 
     * file based on the Player's position and direction they are facing.
     * It then writes the appropriate information to the JTextPane referenced
     * by the infoPane field.
     * @param node The value that indicates the scene the Player is currently on.
     * @param dir The value that indicates the Player's direction.
     * @param type The value that determines the information to be displayed.
     */
    public String getInformationFromFile(int node, int dir, int type)
    {
    	File file = new File("src/assets/info/info.dat");	// Get file from src.
    	String line; // Each line of text on the file.
    	
    	try {
    		Scanner infoFile = new Scanner(file);
    		
        	int _node; 	 // Node at information being looked at.
        	int _dir;  	 // Dir at information being looked at.
        	int _type; 	 // Type of information being looked at.
        	String info; // Information string to be returned.
        	
        	while(infoFile.hasNext())
        	{
        		String[] token;
        		line = infoFile.nextLine();
        		token = line.split(":");
        		
        		_node = Integer.parseInt(token[0]);	// Get node from line.
        		_dir = Integer.parseInt(token[1]);	// Get dir from line.
        		_type = Integer.parseInt(token[2]); // Get type from line.
        		info = token[3];					// Get the String of info from line.
        		
        		if(_node == node && _dir == dir && _type == type)
        		{
        			infoFile.close();
        			return info;
        		}
        	}
        	
        	infoFile.close();
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "~ ERROR ~ LINE 114";
    }
    
    /**
     * The updateInformation method updates the text that is displayed
     * to the Player based on the Player's node and direction values
     * as well as the information type.
     * @param node The value that indicates the scene the Player is currently on.
     * @param dir The value that indicates the Player's direction.
     * @param type The value that determines the information to be displayed.
     */
    public void updateInformation(int node, int dir, int type)
    {
    	this.infoPane.setText(this.getInformationFromFile(node, dir, type));
    }

}
