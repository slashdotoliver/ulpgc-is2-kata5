package kata5.architecture.model;

import java.net.URI;
import java.util.Optional;

public record User(
        Name name,
        String email,
        Gender gender,
        Optional<URI> profilePicture
) {
    public enum Gender {Male, Female,}

    public record Name(String first, String last) { }
}
