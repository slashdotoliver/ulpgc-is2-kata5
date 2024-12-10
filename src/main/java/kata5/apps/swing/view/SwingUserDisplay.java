package kata5.apps.swing.view;

import kata5.architecture.model.User;
import kata5.architecture.view.UserDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SwingUserDisplay extends JPanel implements UserDisplay {

    private final JLabel nameLabel = new JLabel();
    private final JLabel emailLabel = new JLabel();
    private final JLabel genderLabel = new JLabel();
    private final JLabel profilePictureLabel = new JLabel();

    public SwingUserDisplay() {
        setLayout(new BorderLayout());
        add(createTextPanel(), BorderLayout.NORTH);
        add(createImagePanel(), BorderLayout.CENTER);
    }

    private Component createTextPanel() {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(nameLabel);
        textPanel.add(emailLabel);
        textPanel.add(genderLabel);

        JPanel parentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        parentPanel.add(textPanel);
        return parentPanel;
    }

    private Component createImagePanel() {
        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(profilePictureLabel);
        return imagePanel;
    }

    @Override
    public void show(User user) {
        nameLabel.setText("name: " + user.name().first() + " " + user.name().last());
        emailLabel.setText("email: " + user.email());
        genderLabel.setText("gender: " + user.gender().name());
        profilePictureLabel.setIcon(null);
    }

    @Override
    public void show(User user, byte[] profilePicture) {
        show(user);
        show(profilePicture);
    }

    private void show(byte[] profilePicture) {
        try {
            profilePictureLabel.setIcon(toImageIcon(profilePicture));
        } catch (IOException ignored) { }
    }

    private ImageIcon toImageIcon(byte[] profilePicture) throws IOException {
        return new ImageIcon(ImageIO.read(new ByteArrayInputStream(profilePicture)));
    }
}
