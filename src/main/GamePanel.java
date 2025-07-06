package src.main;

import javax.swing.*;
import java.awt.Color;

/** 
 * GamePanel class for the game application.
 * This class handles the game rendering and input.
 * It extends JPanel to provide a custom drawing area for the game.
 * The panel listens for keyboard and mouse events to control the game.
 * The paintComponent method is overridden to render the game graphics.
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; // Original size of each tile in pixels
    final int scale = 3; // Scale factor for the game
    final int tileSize = originalTileSize * scale; // Size of each tile in pixels = 48
    final int maxScreenCol = 16; // Maximum number of columns on the screen
    final int maxScreenRow = 12; // Maximum number of rows on the screen
    final int screenWidth = tileSize * maxScreenCol; // Width of the screen in pixels = 768
    final int screenHeight = tileSize * maxScreenRow; // Height of the screen in pixels = 576
    
    // Add the main thread of the game
    Thread gameThread; // Thread for running the game loop

    /**
     * Constructor for the GamePanel.
     * Initializes the panel with preferred size, focus, background color, and double buffering.
     * It also sets up input listeners for keyboard and mouse events.
     */
    public GamePanel() {
        setPreferredSize(new java.awt.Dimension(screenWidth, screenHeight)); // Set the preferred size
        setFocusable(true); // Make the panel focusable to receive key events
        requestFocusInWindow(); // Request focus for the panel
        setBackground(Color.BLUE); // Set the background color
        setDoubleBuffered(true); // Enable double buffering for smoother rendering
    }


    /**
     * Method to start the game thread.
     * This method initializes and starts the game loop thread.
     */
    public void startGameThread() {
        gameThread = new Thread(this); // Create a new thread for the game
        gameThread.setName("Game Thread"); // Set the name of the thread for debugging
        gameThread.start(); // Start the game thread by automatically calling the run method
    }

    /**
     * The run method for the game loop.
     * This method contains the main game loop logic.
     * It will be executed when the game thread starts.
     * The game loop typically includes updating game state, rendering graphics, and handling input.
     */
    @Override
    public void run() {
        // Game loop logic goes here
        // This method will be called when the game thread starts
    }

    /**
     * Method to stop the game thread.
     * This method interrupts the game loop thread, effectively stopping the game.
     */
    public void stopGameThread() {
        if (gameThread != null && gameThread.isAlive()) {
            gameThread.interrupt(); // Interrupt the game thread to stop it
        }
    }
}