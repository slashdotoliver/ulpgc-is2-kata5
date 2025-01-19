package es.ulpgc.kata5.architecture.io.randomuserapi;

import es.ulpgc.kata5.architecture.io.UserAdapter;
import es.ulpgc.kata5.architecture.data.pojo.randomuserapi.RUUser;
import es.ulpgc.kata5.architecture.model.User;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class RUUserAdapter implements UserAdapter<RUUser> {
    @Override
    public User from(RUUser ruUser) {
        return new User(
                nameOf(ruUser),
                emailOf(ruUser),
                genderOf(ruUser),
                profilePictureOf(ruUser)
        );
    }

    private static User.Name nameOf(RUUser ruUser) {
        return new User.Name(ruUser.name().first(), ruUser.name().last());
    }

    private static String emailOf(RUUser ruUser) {
        return ruUser.email();
    }

    private static User.Gender genderOf(RUUser ruUser) {
        return User.Gender.valueOf(firstToUpperCase(ruUser.gender()));
    }

    private static String firstToUpperCase(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    private static Optional<URI> profilePictureOf(RUUser ruUser) {
        return uriFrom(ruUser.picture().large());
    }

    private static Optional<URI> uriFrom(String uri) {
        try {
            return Optional.of(new URI(uri));
        } catch (URISyntaxException ignored) { }
        return Optional.empty();
    }
}
