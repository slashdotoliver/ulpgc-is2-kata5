package es.ulpgc.kata5.architecture.control.io.randomuserapi;

import es.ulpgc.kata5.architecture.control.io.Provider;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

public class RUImageProvider implements Provider<byte[]> {

    private static final Set<String> RANDOMUSER_URL_PREFIXES = Set.of(
            "https://randomuser.me/api",
            "http://randomuser.me/api"
    );

    private final URL url;

    public RUImageProvider(URL url) {
        this.url = url;
    }

    @Override
    public byte[] retrieve() throws IOException {
        if (RANDOMUSER_URL_PREFIXES.stream().noneMatch(prefix -> url.toString().startsWith(prefix)))
            throw new IOException(
                    "Tried retrieving image from: " +
                            url.toString() +
                            "but failed because it did not start with any valid prefix: " +
                            RANDOMUSER_URL_PREFIXES
            );
        return Jsoup.connect(url.toString()).ignoreContentType(true).execute().bodyAsBytes();
    }
}
