package ca.mcgill.ecse223.tileo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DeckPanel extends JPanel {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DeckPanel(), BorderLayout.CENTER);
		frame.setSize(220, 300);
	}
	
	//***TESTING VARIABLES***
	String descriptionTextTest = "You get another turn! Roll the die and move your player to a new tile.";
	String titleTextTest = "Roll Die Action Card";
	
	//Components
	static final String TITLE_TEXT_DEFAULT = "\n\n\n Action Cards";
	static final String DESCRIPTION_TEXT_DEFAULT = "";
	String titleText = TITLE_TEXT_DEFAULT;
	String descriptionText = DESCRIPTION_TEXT_DEFAULT;
	JTextArea description = new JTextArea(descriptionText, 20, 14);
	JTextArea title= new JTextArea(titleText);
	
	//Constructor
	public DeckPanel(){
		initComponents();
	}
	
	public void refresh(){
		title.setText(titleText);
		description.setText(descriptionText);
	}
	
	public void setToDefault(){
		titleText = TITLE_TEXT_DEFAULT;
		descriptionText = DESCRIPTION_TEXT_DEFAULT;
		refresh();
	}
	
	public void setCardInfo(String aTitle, String aDescription){
		titleText = aTitle;
		descriptionText = aDescription;
		refresh();
	}
	
	public void initComponents(){
		description.setBackground(Color.BLUE);
		title.setBackground(Color.BLUE);
		title.setLineWrap(true);
		title.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		
		title.setFont(new Font("Gill Sans",Font.BOLD , 30));
		title.setForeground(Color.WHITE);
		title.setEditable(false);
		
		description.setFont(new Font("Gill Sans",Font.PLAIN , 23));
		description.setForeground(Color.WHITE);
		description.setEditable(false);
		
		
		//Component layout
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//Horizontal
		layout.setHorizontalGroup(
				layout.createParallelGroup()
						.addComponent(title)
						.addComponent(description)
		);
		
		//Vertical
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGap(20)
					.addComponent(title)
					.addGap(20)
					.addComponent(description)
		);
		
		//this.add(title);
		//this.add(description);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		doDrawing(g);
	}
	
	public void doDrawing(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		RoundRectangle2D rect = new RoundRectangle2D.Float(0, 0, 220, 300, 30, 30);
		g2d.fill(rect);
	}
	
}