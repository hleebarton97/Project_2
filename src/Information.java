/**
 * Information class requires a text pane and handles the information
 * being written to the player.
 * 
 * This allows the lore of the game to be created.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JTextPane;

public class Information 
{
	
	private JTextPane infoPane;	// Our JTextPane to write information to.
    
	/**
	 * Constructor must accept a JTextPane object.
	 * @param infoPane
	 */
    public Information(JTextPane infoPane)
    {
        this.setInformationPanel(infoPane); // Set the current JTextPane to JFrame.
        this.updateInformation(0, 0, 0); 	// Start of game information.
    }
    
    
// Setter:
    
    /**
     * Sets the JTextPane to the passed in JTextPane to write information to.
     * @param infoPane
     */
    public void setInformationPanel(JTextPane infoPane)
    {
    	this.infoPane = infoPane;
    }
    

// Getter:
    
    /**
     * Gets the current JTextPane.
     * @return
     */
    public JTextPane getInformationPanel()
    {
        return this.infoPane;
    }
    

// Functions:
    
    /**
     * Write the string passed in to the current JTextPane.
     * @param info
     */
    public void writeInformation(String info)
    {
        this.infoPane.setText(info);
    }
    
    /**
     * Reads the information from the file based on the player's 
     * postion and direction they are facing.
     * 
     * It then writes the appropriate information to the JTextPane.
     * 
     * @param node
     * @param dir
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
     * Update information pane based on 
     * @param node
     * @param dir
     */
    public void updateInformation(int node, int dir, int type)
    {
    	this.infoPane.setText(this.getInformationFromFile(node, dir, type));
    }

}
