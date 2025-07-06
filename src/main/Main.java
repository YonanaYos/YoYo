package src.main;

import javax.swing.*;

/**
 * Main class for the game application.
 * This class sets up the main window and initializes the game components.
 * It includes a simple menu, a game panel, and basic input handling.
 * To run the game, simply execute the main method.
 * 
 * @author Yoana Yosifova
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack(); // Pack the frame to fit the preferred size of the game panel

        frame.setVisible(true);

        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false); // Disable resizing of the window        
    }
}
