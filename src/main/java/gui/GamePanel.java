package gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.Main;

import java.awt.Color;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

/** 
 * GamePanel class for the game application.
 * This class handles the game rendering and input.
 * It extends JPanel to provide a custom drawing area for the game.
 * The panel listens for keyboard and mouse events to control the game.
 * The paintComponent method is overridden to render the game graphics.
 */
public class GamePanel extends JPanel implements Runnable{
    // Add the main thread of the game
    Thread gameThread; // Thread for running the game loop

    private ImageIcon backgroundImage; // store background image
    private JLabel backgroundLabel; // Label to display the background image

    private final int WIDTH = 1470; // Width of the main window
    private final int HEIGHT = 900; // Height of the main window

    /**
     * Constructor for the GamePanel.
     * Initializes the panel with preferred size, focus, background color, and double buffering.
     * It also sets up input listeners for keyboard and mouse events.
     */
    public GamePanel() {
        java.net.URL imageUrl = this.getClass().getResource("/image.png"); // Load the image from resources
        
        if (imageUrl == null) {
            System.err.println("Image not found!");
            return; // Exit if the image is not found
        } 

        ImageIcon originalIcon = new ImageIcon(imageUrl); // Create an ImageIcon from the URL
        java.awt.Image scaledImage = originalIcon.getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH); // Scale the image to fit the panel
        backgroundImage = new ImageIcon(scaledImage); // Load the background image from resources
        
        backgroundLabel = new JLabel(backgroundImage); // Create a label to hold the background image
        backgroundLabel.setSize(WIDTH, HEIGHT); // Set the size of the label to match the panel size
        backgroundLabel.setOpaque(true); // Make the label opaque to show the background image
        backgroundLabel.setBounds(0, 0, WIDTH, HEIGHT); // Set the bounds of the label to fill the panel
        
        this.setBackground(Color.BLACK); // Set the background color of the label
        this.setLayout(null); // Use no layout manager to position components manually
        this.add(backgroundLabel); // Add the background label to the panel

        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT)); // Set the preferred size
        setFocusable(true); // Make the panel focusable to receive key events
        requestFocusInWindow(); // Request focus for the panel
        setDoubleBuffered(true); // Enable double buffering for smoother rendering
    }

    @Override
    public void run() {
        // game loop logic
    }

    public void startGameThread() {
        Thread gameThread = new Thread(this);
        gameThread.setName("Game Thread");
        gameThread.start();
    }
}