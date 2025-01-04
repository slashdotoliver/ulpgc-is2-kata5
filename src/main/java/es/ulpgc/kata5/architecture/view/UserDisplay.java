package es.ulpgc.kata5.architecture.view;

import es.ulpgc.kata5.architecture.model.User;

public interface UserDisplay {
    void show(User user, byte[] profilePicture);

    void show(User user);
}
