package es.ulpgc.kata5.architecture.commands;

import es.ulpgc.kata5.architecture.io.Provider;
import es.ulpgc.kata5.architecture.io.randomuserapi.RUImageProvider;
import es.ulpgc.kata5.architecture.io.randomuserapi.RUUserProvider;
import es.ulpgc.kata5.architecture.model.User;
import es.ulpgc.kata5.architecture.view.UserDisplay;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class DisplayRandomUserCommand implements Command {

    private final Provider<User> userProvider = new RUUserProvider();
    private final Logger logger = Logger.getLogger(DisplayRandomUserCommand.class.getSimpleName());
    private final UserDisplay userDisplay;

    public DisplayRandomUserCommand(UserDisplay userDisplay) {
        this.userDisplay = userDisplay;
    }

    @Override
    public void execute() {
        try {
            User user = userProvider.retrieve();

            if (user.profilePicture().isPresent())
                userDisplay.show(user, retrieveImageFrom(user.profilePicture().get()));
            else
                userDisplay.show(user);
        } catch (IOException e) {
            logger.severe("Failed retrieving a user or its profile picture.\n" + e.getMessage());
        }
    }

    private byte[] retrieveImageFrom(URI profilePicture) throws IOException {
        return new RUImageProvider(profilePicture.toURL()).retrieve();
    }
}
