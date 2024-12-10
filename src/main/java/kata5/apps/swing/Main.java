package kata5.apps.swing;

import kata5.apps.swing.view.SwingMainFrame;
import kata5.architecture.control.commands.Command;
import kata5.architecture.control.commands.DisplayRandomUserCommand;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Command> COMMANDS = new HashMap<>();
    private static final String DISPLAY_RANDOM_USER_COMMAND_NAME = "display-random-user";

    public static void main(String[] args) {
        var mainFrame = new SwingMainFrame();
        setupDisplayRandomUserCommand(mainFrame);
        mainFrame.setVisible(true);
    }

    private static void setupDisplayRandomUserCommand(SwingMainFrame mainFrame) {
        COMMANDS.put(
                DISPLAY_RANDOM_USER_COMMAND_NAME,
                new DisplayRandomUserCommand(mainFrame.getUserDisplay())
        );
        mainFrame.getDisplayRandomUserButton().addActionListener(
                e -> COMMANDS.get(DISPLAY_RANDOM_USER_COMMAND_NAME).execute()
        );
    }
}
