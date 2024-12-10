package kata5.architecture.control.io;

import java.io.IOException;

public interface Provider<T> {
    T retrieve() throws IOException;
}
