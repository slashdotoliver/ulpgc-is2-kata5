package kata5.architecture.control.commands;

import kata5.architecture.control.io.Provider;
import kata5.architecture.control.io.randomuserapi.RUImageProvider;
import kata5.architecture.control.io.randomuserapi.RUUserProvider;
import kata5.architecture.model.User;
import kata5.architecture.view.UserDisplay;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class DisplayRandomUserCommand implements Command {

    private static final Provider<User> USER_PROVIDER = new RUUserProvider();
    private static final Logger LOGGER = Logger.getLogger(DisplayRandomUserCommand.class.getSimpleName());
    private final UserDisplay userDisplay;

    public DisplayRandomUserCommand(UserDisplay userDisplay) {
        this.userDisplay = userDisplay;
    }

    @Override
    public void execute() {
        try {
            User user = USER_PROVIDER.retrieve();

            if (user.profilePicture().isPresent())
                userDisplay.show(user, retrieveImageFrom(user.profilePicture().get()));
            else
                userDisplay.show(user);
        } catch (IOException e) {
            LOGGER.severe("Failed retrieving a user or its profile picture.\n" + e.getMessage());
        }
    }

    private byte[] retrieveImageFrom(URI profilePicture) throws IOException {
        return new RUImageProvider(profilePicture.toURL()).retrieve();
    }
}
