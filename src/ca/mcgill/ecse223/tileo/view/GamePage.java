package ca.mcgill.ecse223.tileo.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayModeController;
import ca.mcgill.ecse223.tileo.model.*;


public class GamePage extends JFrame {

	// data elements
	private String error = null;
	private Game game;

	// Components
	JPanel rightPanel = new JPanel();
	BoardPanel board = new BoardPanel(Game.Mode.DESIGN);
	DeckPanel deck = new DeckPanel();
	JButton getCard = new JButton("Get Action Card");
	JButton rollDie = new JButton("Roll Die");
	JButton finishTurn = new JButton("Move To Tile");
	JButton addConnection = new JButton("Add Connection");
	JButton removeConnection = new JButton("Remove Connection");
	JTextField dieResult = new JTextField(20);
	JLabel status = new JLabel("Current Player:");
	JLabel currentPlayer = new JLabel("Player 1");
	JButton save = new JButton("Save");

	public GamePage() {
		game=TileOApplication.getCurrentGame();
		game.setMode(Game.Mode.GAME);
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(885, 682);
		setResizable(false);

		// Settings for text field
		dieResult.setFont(new Font("Futura", Font.BOLD, 56));
		dieResult.setEditable(true);

		// Change fonts
		status.setFont(new Font("Futura", Font.PLAIN, 26));
		currentPlayer.setFont(new Font("Futura", Font.BOLD, 30));

		// Set Group Layout
		GroupLayout layout = new GroupLayout(getContentPane());
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Add listeners for buttons
		getCard.addActionListener(new getCardListener());
		rollDie.addActionListener(new rollDieListener());
		finishTurn.addActionListener(new finishTurnListener());
		addConnection.addActionListener(new addConnectionListener());
		removeConnection.addActionListener(new removeConnectionListener());

		// Component placement
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(board, 647, 647, 647)
				.addGroup(layout.createParallelGroup()
						.addComponent(status)
						.addComponent(currentPlayer)
						.addComponent(deck, 220, 220, 220)
						.addComponent(getCard, 220, 220, 220)
						.addComponent(addConnection, 220, 220, 220)
						.addComponent(removeConnection, 220, 220, 220)
						.addGap(220, 220, 220)
						.addGroup(layout.createSequentialGroup()
								.addComponent(rollDie, 140, 140, 140)
								.addComponent(dieResult, 70, 70, 70))
						.addComponent(finishTurn, 220, 220, 220)
						.addComponent(save, 220, 220, 220)
				)
		);
		layout.setVerticalGroup(layout.createParallelGroup()
				.addComponent(board, 647, 647, 647)
				.addGroup(layout.createSequentialGroup()
						.addComponent(status)
						.addComponent(currentPlayer)
						.addComponent(deck, 300, 300, 300)
						.addComponent(getCard)
						.addComponent(addConnection)
						.addComponent(removeConnection)
						.addGroup(layout.createParallelGroup()
								.addComponent(dieResult, 70, 70, 70)
								.addGroup(layout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addComponent(rollDie)))
						.addComponent(finishTurn)
						.addComponent(save)));
	}

	class getCardListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// TODO Add button functionality.
		}
	}

	class rollDieListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// TODO Add button functionality.
			rollDieActionPerformed(ev);
		}
	}

	class finishTurnListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// TODO Add button functionality.
		}
	}

	class addConnectionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// TODO Add button functionality.
		}
	}

	class removeConnectionListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// TODO Add button functionality.
		}
	}

	// Thomas
	// TODO Implement this
	public void rollDieActionPerformed(ActionEvent ev) {
		// clear error message
		error = null;

		// Call the controller
		PlayModeController toc = new PlayModeController();
		Game game = TileOApplication.getCurrentGame();
		Player currentPlayer = game.getCurrentPlayer();
		Tile currentTile = currentPlayer.getCurrentTile();

		// pass the returned list of tiles somewhere
		// need to update the visual with the number of the die roll but only
		// the list of tiles is returned
		int number = toc.rollDie();
		java.util.List<Tile> tiles = toc.generateMoves(currentTile, number);
		for(Tile t : tiles){
			BoardPanel.Rectangle2DCoord rect = this.board.getRectangle(t.getX(), t.getY());
			if(rect != null){
				rect.setColor(Color.YELLOW);
			}
		}
		// update die visual
		refresh(number);

	}

	// Thomas
	// TODO Fully implement
	private void refresh(int number) {
		dieResult.setText(Integer.toString(number));
	}
}
