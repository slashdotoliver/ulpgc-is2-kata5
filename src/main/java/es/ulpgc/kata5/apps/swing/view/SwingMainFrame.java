package es.ulpgc.kata5.apps.swing.view;

import es.ulpgc.kata5.architecture.view.UserDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMainFrame extends JFrame {

    private final JButton displayRandomUserButton = new JButton("Show Random User");
    private UserDisplay userDisplay;

    public SwingMainFrame() throws HeadlessException {
        setTitle("Random User Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        add(createUserDisplay(), BorderLayout.CENTER);
        add(getDisplayRandomUserButton(), BorderLayout.SOUTH);
    }

    private Component createUserDisplay() {
        var result = new SwingUserDisplay();
        userDisplay = result;
        return result;
    }

    public JButton getDisplayRandomUserButton() {
        return displayRandomUserButton;
    }

    public UserDisplay getUserDisplay() {
        return userDisplay;
    }
}
