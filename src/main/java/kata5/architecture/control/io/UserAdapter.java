package kata5.architecture.control.io;

import kata5.architecture.model.User;

public interface UserAdapter<T> {
    User from(T value);
}
