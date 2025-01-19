package es.ulpgc.kata5.architecture.io;

import es.ulpgc.kata5.architecture.model.User;

public interface UserAdapter<T> {
    User from(T value);
}
