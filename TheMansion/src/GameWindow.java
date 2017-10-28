import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Rectangle;
import net.miginfocom.swing.MigLayout;

public class GameWindow {

	private JFrame frame;

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
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 350, 300);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(370, 11, 204, 300);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setRequestFocusEnabled(false);
		textPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textPane.setBounds(10, 29, 184, 260);
		panel_1.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 184, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 322, 204, 228);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 0, 184, 30);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(224, 322, 350, 228);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new MigLayout("", "[70px][70px][70px][70px][70px]", "[45px][45px][45px][45px][45px]"));
		
		JLabel label_1 = new JLabel("");
		panel_3.add(label_1, "cell 1 0,grow");
		
		JLabel label_2 = new JLabel("");
		panel_3.add(label_2, "cell 2 0,grow");
		
		JLabel label_3 = new JLabel("");
		panel_3.add(label_3, "cell 3 0,grow");
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4, "cell 4 0,grow");
		
		JLabel label_5 = new JLabel("");
		panel_3.add(label_5, "cell 0 1,grow");
		
		JLabel label_6 = new JLabel("");
		panel_3.add(label_6, "cell 1 1,grow");
		
		JButton btnForward = new JButton("Forward");
		btnForward.setBounds(new Rectangle(0, 0, 90, 30));
		panel_3.add(btnForward, "cell 2 1,grow");
		
		JButton btnNewButton_1 = new JButton("Left");
		panel_3.add(btnNewButton_1, "cell 1 2,grow");
		
		JButton btnNewButton = new JButton("Pick Up");
		panel_3.add(btnNewButton, "cell 2 2,grow");
		
		JButton btnNewButton_2 = new JButton("Right");
		panel_3.add(btnNewButton_2, "cell 3 2,grow");
		
		JLabel label_10 = new JLabel("");
		panel_3.add(label_10, "cell 4 2,grow");
		
		JLabel label_11 = new JLabel("");
		panel_3.add(label_11, "cell 0 3,grow");
		
		JLabel label_12 = new JLabel("");
		panel_3.add(label_12, "cell 1 3,grow");
		
		JButton btnNewButton_3 = new JButton("Back");
		panel_3.add(btnNewButton_3, "cell 2 3,grow");
		
		JLabel label_13 = new JLabel("");
		panel_3.add(label_13, "cell 3 3,grow");
		
		JLabel label_14 = new JLabel("");
		panel_3.add(label_14, "cell 4 3,grow");
		
		JLabel label_15 = new JLabel("");
		panel_3.add(label_15, "cell 0 4,grow");
		
		JLabel label_16 = new JLabel("");
		panel_3.add(label_16, "cell 1 4,grow");
		
		JLabel label_17 = new JLabel("");
		panel_3.add(label_17, "cell 2 4,grow");
		
		JLabel label_18 = new JLabel("");
		panel_3.add(label_18, "cell 3 4,grow");
		
		JLabel label_19 = new JLabel("");
		panel_3.add(label_19, "cell 4 4,grow");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
