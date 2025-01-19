package es.ulpgc.kata5.architecture.io;

import java.io.IOException;

public interface Provider<T> {
    T retrieve() throws IOException;
}
