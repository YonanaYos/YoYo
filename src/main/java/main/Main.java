package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.GamePanel;

/**
 * Main class for the game application.
 * This class sets up the main window and initializes the game components.
 * It includes a simple menu, a game panel, and basic input handling.
 * To run the game, simply execute the main method.
 * 
 * @author Yoana Yosifova
 */
public class Main extends JFrame {

    public static void main(String[] args) {
        // Use invokeLater to ensure the GUI is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {

            MyFrame frame = new MyFrame("My Monthly Meal Planner"); // Create a new instance of MyFrame
            GamePanel gamePanel = new GamePanel();
            frame.add(gamePanel);
            gamePanel.startGameThread(); // Start the game loop after the panel is set up and visible.

            //pack() should be called before setting the location and visibility
            // frame.pack(); // Pack the frame to fit the preferred size of the game panel
        });
    }
}