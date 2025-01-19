package es.ulpgc.kata5.architecture.io.randomuserapi;

import com.google.gson.Gson;
import es.ulpgc.kata5.architecture.io.Provider;
import es.ulpgc.kata5.architecture.io.UserAdapter;
import es.ulpgc.kata5.architecture.data.pojo.randomuserapi.RUResponse;
import es.ulpgc.kata5.architecture.data.pojo.randomuserapi.RUUser;
import es.ulpgc.kata5.architecture.model.User;
import org.jsoup.Jsoup;

import java.io.IOException;

public class RUUserProvider implements Provider<User> {

    private static final String RANDOMUSER_API_URL = "https://randomuser.me/api";

    private final Gson gson = new Gson();
    private final UserAdapter<RUUser> userAdapter = new RUUserAdapter();

    @Override
    public User retrieve() throws IOException {
        return userAdapter.from(
                gson.fromJson(Jsoup.connect(RANDOMUSER_API_URL).ignoreContentType(true).get().text(), RUResponse.class)
                        .results()
                        .getFirst()
        );
    }
}
