package es.ulpgc.kata5.architecture.control.io;

import es.ulpgc.kata5.architecture.model.User;

public interface UserAdapter<T> {
    User from(T value);
}
