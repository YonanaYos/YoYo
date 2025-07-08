package main;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
            
            JFrame frame = new JFrame("My Monthly Cycle");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBackground(Color.BLACK);

            JLabel gameDescription = new JLabel("Welcome to 'My Monthly Cycle' education game! \n Press the 'START' button to begin");
            gameDescription.setHorizontalAlignment(JLabel.CENTER);
            frame.add(gameDescription);

            JButton startButton = new JButton("START");
            startButton.addActionListener(e -> {
                // Remove the description label and start button when the game starts
                frame.remove(gameDescription);
                frame.remove(startButton);
                frame.revalidate(); // Refresh the frame to reflect changes
                frame.repaint(); // Repaint the frame to update the display

                GamePanel gamePanel = new GamePanel();
                frame.add(gamePanel);
                
                //pack() should be called before setting the location and visibility
                frame.pack(); // Pack the frame to fit the preferred size of the game panel
            
                frame.setLocationRelativeTo(null); // Center the window on the screen
                frame.setVisible(true); // Make the frame visible
                gamePanel.startGameThread(); // Start the game loop after the panel is set up and visible.
            });
        });
    }
}