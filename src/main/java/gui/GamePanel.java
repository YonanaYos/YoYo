package gui;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/** 
 * GamePanel class for the game application.
 * This class handles the game rendering and input.
 * It extends JPanel to provide a custom drawing area for the game.
 * The panel listens for keyboard and mouse events to control the game.
 * The paintComponent method is overridden to render the game graphics.
 */
public class GamePanel extends JPanel implements Runnable {
    // Add the main thread of the game
    Thread gameThread; // Thread for running the game loop

    private ImageIcon backgroundImage; // store background image
    private JLabel backgroundLabel; // Label to display the background image

    private final int WIDTH = 1200; // Width of the main window
    private final int HEIGHT = 700; // Height of the main window

    /**
     * Constructor for the GamePanel.
     * Initializes the panel with preferred size, focus, background color, and double buffering.
     * It also sets up input listeners for keyboard and mouse events.
     */
    public GamePanel() {
        // Must be called before adding components for absolute positioning
        this.setLayout(null); // Use no layout manager to position components manually

        /**************************************************
        ************          IMAGE          **************
        ***************************************************/
        ImageIcon originalIcon = loadImage("/image.png"); // Create an ImageIcon from the URL
        backgroundImage = scaleImage(originalIcon, WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH); // Load the background image from resources

        /***************************************************
        ************     BACKGROUND LABEL     **************
        ***************************************************/
        backgroundLabel = new JLabel(backgroundImage); // Create a label to hold the background image
        backgroundLabel.setSize(WIDTH, HEIGHT); // Set the size of the label to match the panel size
        backgroundLabel.setOpaque(false); // Make the label opaque to show the background image
        backgroundLabel.setBounds(0, 0, WIDTH, HEIGHT); // Set the bounds of the label to fill the panel
        backgroundLabel.setLayout(null); // Use no layout manager for the label to position components manually
        this.add(backgroundLabel); // Add the background label to the panel

        /**************************************************
        ************       START BUTTON      **************
        ***************************************************/
        JButton startButton = new JButton("START");
        startButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20)); // Set the font of the button
        startButton.setBounds(WIDTH / 2 - 50, HEIGHT / 2 - 25, 100, 50); // Center the button
        startButton.setBackground(Color.WHITE); // Set background to green
        startButton.setForeground(Color.BLACK); // Set text color to black
        startButton.setContentAreaFilled(true); // Fill the button background
        startButton.setOpaque(true); // Make button opaque
        backgroundLabel.add(startButton); // Add button to the label

        /**************************************************
        ************        GAME PANEL       **************
        ***************************************************/
        this.setBackground(new Color(139,111,90,255)); // Set the background color of the label
        this.setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT)); // Set the preferred size
        this.setFocusable(true); // Make the panel focusable to receive key events
        this.requestFocusInWindow(); // Request focus for the panel
        this.setDoubleBuffered(true); // Enable double buffering for smoother rendering
        this.setVisible(true); // Make the panel visible
    }

    /**************************************************
    ************      IMAGE LOADING      **************
    ***************************************************/

    private ImageIcon loadImage(String path) {
        java.net.URL imageUrl = this.getClass().getResource(path);

        if (imageUrl == null) {
            System.err.println("Image not found!");
            return null; // Exit if the image is not found
        } 

        return new ImageIcon(imageUrl); // Create and return an ImageIcon from the URL
    }

    private ImageIcon scaleImage(ImageIcon originalIcon, int width, int height, int hints) {
        java.awt.Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, hints);
        return new ImageIcon(scaledImage);
    }

    /**************************************************
    ************    GAME LOOP METHODS    **************
    ***************************************************/

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