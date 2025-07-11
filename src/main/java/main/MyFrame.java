package main;

import javax.swing.JFrame;
import java.awt.Color;

public class MyFrame extends JFrame {
    String title; // Title of the frame
    private final static int WIDTH = 1500; // Width of the main window
    private final static int HEIGHT = 1000; // Height of the main window

    // Make a constructor for the frame of the game
    public MyFrame(String title) {
        // Create a new JFrame object

        this.title = title;
        this.setSize(WIDTH, HEIGHT); // Set the size of the main window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when you click 'X' button
        this.setResizable(false); // Disable resizing of the window
        this.setBackground(new Color(139,111,90,255));

        this.setLocationRelativeTo(null); // Center the window on the screen
        this.setVisible(true); // Make the frame visible
    }
}
